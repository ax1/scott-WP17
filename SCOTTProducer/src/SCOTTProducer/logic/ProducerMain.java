package SCOTTProducer.logic;

import SCOTTProducer.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import org.smool.kpi.model.exception.KPIModelException;

import com.sun.jmx.snmp.Timestamp;

import SCOTTProducer.model.smoolcore.IAlarm;
import SCOTTProducer.model.smoolcore.ILogicalLocation;
import SCOTTProducer.model.smoolcore.IMessage;
import SCOTTProducer.model.smoolcore.IMessageReceiveSensor;



public class ProducerMain {
	
	public static void main(String [] args) throws Exception{
		
		
		Random sectorCounter = new Random();
		Random sensorCounter = new Random();
		Producer p = null;
		String sensorID = "SECTORSensor" + UUID.randomUUID();
		
		SmoolKP.setKPName(sensorID);
		SmoolKP.synchronousSearch(1000, true);
		if (!SmoolKP.isSIBfound()) throw new IOException ("No SIB has been found");
		//boolean connected= SmoolKP.connectToSIB("ScottSIB", "172.24.4.98", "23000",1000);
		//boolean connected= SmoolKP.connectToSIB("ScottSIB", "smool.tecnalia.com", "23000",1000);
		boolean connected= SmoolKP.connectToSIB(1000);
		if (connected) {
				System.out.println("Successfully connected to SIB");
				String body="sensorID: "+(sensorCounter.nextInt(10) + 1)+ " sectorID: "+(sectorCounter.nextInt(5) + 1);
				IMessage info = SmoolKPHelper.createEmailMessageMessage(null, body, UUID.randomUUID().toString(), "SCOTT sensor",Long.toString(System.currentTimeMillis()));
				try {
					p = SmoolKP.getProducer();
					sensorID = p.createMessageReceiveSensor(sensorID, "device0","Tecnalia",new ArrayList<IAlarm>(), new ArrayList<ILogicalLocation>(), null, info,null);					
					while (true) {
						Thread.sleep(1000);
						info.setBody("sensorID: "+(sensorCounter.nextInt(10) + 1)+ " sectorID: "+(sectorCounter.nextInt(5) + 1));
						info.setTimestamp(new Timestamp().toString());
						p.updateMessageReceiveSensor(sensorID, "device0", "Tecnalia", new ArrayList<IAlarm>(), new ArrayList<ILogicalLocation>(), null, info, null);
						System.out.println("message updated: " + info.getBody());
					}
		
				} catch (KPIModelException e) {
					e.printStackTrace();
					System.out.println("KP Exception Raised.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

		}
		else {
			System.out.println("Couldn't connect to the SIB.");
			System.exit(-1);
		}	}
	
}