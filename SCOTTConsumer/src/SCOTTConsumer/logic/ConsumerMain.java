package SCOTTConsumer.logic;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import SCOTTConsumer.api.*;
import SCOTTConsumer.model.smoolcore.impl.MessageReceiveSensor;

/**
 * TODOs
 * 1-review observer & observer 2 (equivalents) and discard one
 * 2-check connect() methods and implement/adapt as library methods in SmoolKP (handier than existing connection methods)
 * 3-look at the exception management in new connect() methods and compare to exisiting boolean result in smoolkp
 * 4-add a infinite loop with sleep for re-triying connections when disconnected (i.e: every 10000 millis)
 *
 */
public class ConsumerMain {
	
	public static void main(String [] args) throws Exception {
		final String name="SCOTTConsumer_"+Long.toString(System.nanoTime());
		new ConsumerMain(name);
	}
	
	public ConsumerMain(String name) throws Exception {
		SmoolKP.setKPName(name);
		//-------------connect to SIB---------------------------------------------
		//connect();
		connect("sib1", "smool.tecnalia.com","80");
		//--------------delay to prevent subscription error---------
		try {Thread.sleep(1000);}catch(Exception e) {;}
		//--------------add custom observer to subscription-------
		
		Observer observer = (o, concept)->	System.out.println("message arrived: "+((MessageReceiveSensor)concept).getMessage().getBody());
		
		Observer observer2=new Observer() {
			public void update(Observable o, Object concept) {
				System.out.println("message arrived: "+((MessageReceiveSensor)concept).getMessage().getBody());
				
			}
		};
		
		Consumer consumer = SmoolKP.getConsumer();
		consumer.subscribeToMessageReceiveSensor(new MessageReceiveSensorSubscription(observer2), null);
		

	}
	
	private void connect() throws IOException {
		SmoolKP.synchronousSearch(1000, true);
		if (SmoolKP.isSIBfound()) {
			System.out.println("Found a SIB: " + SmoolKP.getDiscoveredSIBs().get(0).getSIBName());
			if (SmoolKP.connectToSIB(1000)) {
				System.out.println("Successfully connected to SIB");
			} else {
				throw new IOException ("Unable to connect to SIB");
			}
		}
	}
	

	private void connect(String name, String ip, String port) throws IOException {
		boolean connected = SmoolKP.connectToSIB(name,ip, port,0);
		if (connected) {
			System.out.println("Successfully connected to SIB");
		} else {
			throw new IOException ("Unable to connect to SIB");
		}
	}
}
