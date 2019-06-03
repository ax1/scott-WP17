/**
 * MQTT client for SMOOL-Project SCOTT
 * 
 *  see https://www.eclipse.org/paho/clients/java/
 *  
 *  Installation:
 *  -  either use Maven or download to lib from  https://search.maven.org/search?q=a:org.eclipse.paho.client.mqttv3
 *  
 *  Usage:
 * - see https://www.eclipse.org/paho/clients/java/ 
 * - see http://www.openmobilealliance.org/tech/profiles/lwm2m/3336.xml [The object for GPS positioning data]
 * 
 * 
 * 
 * For SCOTT project see the following documents:
 * -  SCOTT: INDRA's CANONICAL Data model (VISIBILITY: internal Indra confidential)
 * -  SCOTT: INDRA's  DSFTM interfaces document (VISIBILITY: internal Indra confidential)
 */

package SCOTTProducer.logic;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class SCOTTMQTTClient {

	private static int harvesterID = 187221;

	/*
	 * from Interfaces document-> send 131100 but from canonical
	 * SERVICE/SUBSERVICE/REGION/SUBREGION/ SOURCE/SUBSOURCE/CRCHead/CRCPay
	 */
	private static String topic = "131100"; //

	private static String clientID = "331"; // id container
	// private static String broker = "tcp://150.241.54.144:1883";
	private static String broker = "mqtt://cmw.ext.innovarail.indra.es:8883";

	private static MqttClient mqttClient;
	private static MemoryPersistence persistence = new MemoryPersistence();

	public static void checkConnect() throws MqttException {
		if (mqttClient == null)
			mqttClient = new MqttClient(broker, clientID, persistence);
		if (!mqttClient.isConnected()) {
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setSSLProperties(props)
			connOpts.setCleanSession(true);
			connOpts.setUserName("yard_planner");
			connOpts.setPassword("tecnalia2019".toCharArray());
			System.out.println("mqtt: connecting to broker: " + broker);
			mqttClient.connect(connOpts);
			System.out.println("mqtt: connected");
			
			
			
			char[] pw = "tecnalia2019".toCharArray();
			KeyStore ks = KeyStore.getInstance("PKCS12");
			ks.load(new FileInputStream(
					"/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/keystore/yard_planner.keystore.jks"),
					pw);
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(ks, pw);
			KeyStore tks = KeyStore.getInstance("JKS");
			tks.load(new FileInputStream("/Users/antares/Tools/rabbitmq/tls/jvm_keystore"), pw);
			;

		}
	}

	/**
	 * Connect by using private key files and TLS
	 * 
	 * @throws MqttException
	 */
//	public static void checkConnect() throws MqttException {
//		if (mqttClient == null)
//			mqttClient = new MqttClient(broker, clientID, persistence);
//		if (!mqttClient.isConnected()) {
//			MqttConnectOptions connOpts = new MqttConnectOptions();
//
//			char[] pw = "tecnalia2019".toCharArray();
//			KeyStore ks = KeyStore.getInstance("PKCS12");
//			ks.load(new FileInputStream(
//					"/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/keystore/yard_planner.keystore.jks"),
//					pw);
//			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
//			kmf.init(ks, pw);
//			KeyStore tks = KeyStore.getInstance("JKS");
//			tks.load(new FileInputStream("/Users/antares/Tools/rabbitmq/tls/jvm_keystore"), pw);
//			connOpts.setSSLProperties(props);
//			connOpts.setCleanSession(true);
//			connOpts.setUserName("scott");
//			connOpts.setPassword("Tecnalia#2019".toCharArray());
//			System.out.println("mqtt: connecting to broker: " + broker);
//			mqttClient.connect(connOpts);
//			System.out.println("mqtt: connected");
//		}
//	}

	public static void setTLS(String) throws Exception {
		    MqttClient client = new MqttClient("ssl://localhost:8883", "paho-java-1");
		    MqttConnectOptions opts = new MqttConnectOptions();

		    final char[] passphrase = "bunnies".toCharArray();

		    // client key
		    KeyStore ks = KeyStore.getInstance("PKCS12");
		    ks.load(new FileInputStream("/Users/antares/Tools/rabbitmq/tls/client_key.p12"), passphrase);

		    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		    kmf.init(ks, passphrase);

		    // server certificate
		    KeyStore tks = KeyStore.getInstance("JKS");
		    // created the key store with
		    // keytool -importcert -alias rmq -file ./server_certificate.pem -keystore ./jvm_keystore
		    tks.load(new FileInputStream("/Users/antares/Tools/rabbitmq/tls/jvm_keystore"), passphrase);

		    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
		    tmf.init(tks);

		    SSLContext ctx = SSLContext.getInstance("SSLv3");
		    ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
		    opts.setSocketFactory(ctx.getSocketFactory());

		    client.connect(opts);
		  }

}

	/**
	 * Connect by using plain mqtt security
	 * 
	 * @throws MqttException
	 */
	public static void checkConnectOLD() throws MqttException {
		if (mqttClient == null)
			mqttClient = new MqttClient(broker, clientID, persistence);
		if (!mqttClient.isConnected()) {
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			connOpts.setUserName("scott");
			connOpts.setPassword("Tecnalia#2019".toCharArray());
			System.out.println("mqtt: connecting to broker: " + broker);
			mqttClient.connect(connOpts);
			System.out.println("mqtt: connected");
		}
	}

	public static void send() {
		try {
			checkConnect();
			String content = message(harvesterID, clientID, 43.295242, -2.891246);
			int qos = 0;
			MqttMessage message = new MqttMessage(content.getBytes());
			message.setQos(qos);
			mqttClient.publish(topic, message);
			System.out.println("mqtt: message published");
			// System.out.println("mqtt: \n"+content);
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}
	}

	/*
	 * 
	 * 6. As example, string “0123456789” will obtain 0xA684C7C6.
	 * 
	 * Data serialized:
	 * 10210420true1153623082014356789033061536230220143567890true14590651
	 * CRCService result: 1079490931
	 * 
	 * 
	 */
	public static int CRC(String data) {
		// TODO: SEE INDRA'S CANONICAL DOCUMENT SECTION 3.1
		// In brief: concatenate, serialize data and then apply XOR to another int.
		int CRC = (int) System.currentTimeMillis() & 0xFFFFFFFF;
		return CRC;
	}

	public static String message(int nodeID, String containerID, double latitude, double longitude) {
		return MESSAGE.replace("$nodeID", Long.toString(nodeID))
				.replace("$timestamp", Long.toString(System.currentTimeMillis())).replace("$containerID", containerID)
				.replace("$latitude", Double.toString(latitude)).replace("$longitude", Double.toString(longitude))
				.replace("$containerID", Double.toString(longitude)).replace("$crc_payload", Long.toString(CRC("")))
				.replace("$crc_service", Long.toString(CRC("")));
}

/**
	 * FILL $timestamp, $nodeID $containerID $latitude $longitude $crc_payload
	 * $crc_service
	 */
	private static String MESSAGE = "{\n" + "  \"ServiceID\": 131100,\n" + "  \"Root\": {\n" + "    \"Gateway\": 0,\n"
			+ "    \"Source\": 0\n" + "  },\n" + "  \"Nodes\": [\n" + "    {\n" + "      \"Safety\": false,\n"
			+ "      \"NodeID\": $nodeID,\n" + "      \"TimeStamp\": $timestamp,\n"
			+ "      \"TimeAccuracy\": 1000000000,\n" + "      \"Sensors-Actuators\": [\n" + "        {\n"
			+ "          \"SensorID\": 3336,\n" + "          \"TimeStamp\": $timestamp,\n"
			+ "          \"TimeAccuracy\": 1000000000,\n" + "          \"Resources\": {\n"
			+ "            \"5750\": \"$containerID\",\n" + "            \"5513\": \"$latitude\",\n"
			+ "            \"5514\": \"$longitude\",\n" + "            \"5515\": \"0\",\n"
			+ "            \"5516\":\"100\"\n" + "          }\n" + "        }\n" + "      ],\n"
			+ "      \"CRC\": $crc_payload\n" + "    }\n" + "  ],\n" + "  \"CRC\": $crc_service\n" + "}";

//	{
//		  "ServiceID": 131100,
//		  "Root": {
//		    "Gateway": 0,
//		    "Source": 0
//		  },
//		  "Nodes": [
//		    {
//		      "Safety": false,
//		      "NodeID": 187221,
//		      "TimeStamp": 1555055619267,
//		      "TimeAccuracy": 1000000000,
//		      "Sensors-Actuators": [
//		        {
//		          "SensorID": 3336,
//		          "TimeStamp": 1555055619267,
//		          "TimeAccuracy": 1000000000,
//		          "Resources": {
//		            "5750": "331",
//		            "5513": "43.295242",
//		            "5514": "-2.891246",
//					"5515":"0",
//		            "5516":"100"
//		          }
//		        }
//		      ],
//		      "CRC": 12237466
//		    }
//		  ],
//		  "CRC": 24495477
//		}
