package SCOTTConsumer.logic;

import java.io.IOException;
import java.util.Observer;

import SCOTTConsumer.api.*;
import SCOTTConsumer.model.smoolcore.impl.MessageReceiveSensor;


public class ConsumerMain {
	
	public static void main(String [] args) throws Exception {
		final String name="SCOTTConsumer_"+Long.toString(System.nanoTime());
		new ConsumerMain(name);
	}
	
	public ConsumerMain(String name) throws Exception {
		SmoolKP.setKPName(name);
		//-------------connect to SIB---------------------------------------------
		connect();
		//connect("s", "192.168.1.2");
		//--------------delay to prevent subscription error---------
		try {Thread.sleep(1000);}catch(Exception e) {;}
		//--------------add custom observer to subscription-------
		Observer observer = (o, concept)->	System.out.println("message arrived: "+((MessageReceiveSensor)concept).getMessage().getBody());
		Consumer consumer = SmoolKP.getConsumer();
		consumer.subscribeToMessageReceiveSensor(new MessageReceiveSensorSubscription(observer), null);
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
	
	private void connect(String name, String ip) throws IOException {
		boolean connected = SmoolKP.connectToSIB(name,ip, "23000",0);
		if (connected) {
			System.out.println("Successfully connected to SIB");
		} else {
			throw new IOException ("Unable to connect to SIB");
		}
	}
}
