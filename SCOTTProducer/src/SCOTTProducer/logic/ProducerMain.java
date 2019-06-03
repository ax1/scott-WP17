package SCOTTProducer.logic;

import java.io.IOException;

import org.smool.kpi.model.exception.KPIModelException;

import SCOTTProducer.api.Producer;
import SCOTTProducer.api.SmoolKP;
import SCOTTProducer.model.smoolcore.impl.PresenceInformation;
import SCOTTProducer.model.smoolcore.impl.PresenceSensor;

/**
 * SCOTT Project: Producer KP
 * 
 * It takes id from harvesters and send to consumers by using SMOOL middleware
 * The concept is a plain Presence, with no location since this is set in the
 * consumer
 */
public class ProducerMain {

	public ProducerMain() throws Exception {

		// connection to SIB
		final String name = "SCOTTProducer" + System.currentTimeMillis() % 10000;
		SmoolKP.connect();

		// create harvester as plain presence sensor
		Producer producer = SmoolKP.getProducer();
		PresenceSensor presenceSensor = new PresenceSensor(name + "sensor");
		PresenceInformation presence = new PresenceInformation(presenceSensor._getIndividualID() + "information");
		presenceSensor.setPresence(presence);
		boolean firstTime = true;

		// Send presence, the location will be set in the consumer
		// This way. configuration is only done in the KPConsumer
		// producer.id->location, presence.id->containerID
		while (true) {
			Thread.sleep(10000);
			presence.setStatus(true).setTimestamp(Long.toString(System.currentTimeMillis()));
			System.out.println("sending status of  harvester" + presenceSensor._getIndividualID());
			if (firstTime) {
				firstTime = false;
				producer.createPresenceSensor(presenceSensor._getIndividualID(), name, "TECNALIA", null, null, presence,
						null);
			} else {
				producer.updatePresenceSensor(presenceSensor._getIndividualID(), name, "TECNALIA", null, null, presence,
						null);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				new ProducerMain();
			} catch (KPIModelException | IOException e) {
				e.printStackTrace();
				Thread.sleep(10000);
				System.out.println("RECONNECTING");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
