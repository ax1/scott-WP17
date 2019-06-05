package SCOTTProducer.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
	ServerSocket serverSocket;

	public ProducerMain() throws Exception {

		// connection to SIB
		final String name = "SCOTTProducer" + System.currentTimeMillis() % 10000;
		// SmoolKP.connect();
		SmoolKP.connect("sib1", "smool.tecnalia.com", 80);

		// create harvester as plain presence sensor
		Producer producer = SmoolKP.getProducer();
		String presenceID = name + "sensor";
		PresenceSensor presenceSensor = new PresenceSensor(presenceID);

		PresenceInformation presence = new PresenceInformation(presenceID + "information");
		presenceSensor.setPresence(presence);
		boolean firstTime = true;

		// create socket for IPC transmission
		serverSocket = new ServerSocket(4444);

		// Send presence, the location will be set in the consumer
		// This way. configuration is only done in the KPConsumer
		// producer.id->location, presence.id->containerID
		while (true) {
			try (Socket socket = serverSocket.accept()) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String harvesterID = reader.readLine();
				socket.close();

				presence.setDataID(harvesterID).setTimestamp(Long.toString(System.currentTimeMillis()));
				System.out.println("sending alive for  harvester " + harvesterID);
				if (firstTime) {
					firstTime = false;
					producer.createPresenceSensor(presenceID, name, "TECNALIA", null, null, presence, null);
				} else {
					producer.updatePresenceSensor(presenceID, name, "TECNALIA", null, null, presence, null);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// Logger.setDebugging(true);
		// Logger.setDebugLevel(4);
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
