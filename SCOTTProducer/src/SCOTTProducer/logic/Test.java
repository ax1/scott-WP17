package SCOTTProducer.logic;

import java.io.FileInputStream;

/*******************************************************************************
 * Copyright (c) 1999, 2015 IBM Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Author:
 *    - Originally taken from https://www.eclipse.org/paho/clients/java/
 *    - James Sutton - Packaged Example and added TLS.
 */

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Test {
	public static void main(String[] args) {

		String topic = "131100";
		String content = "aaaaaaaaaaaaaa";
		int qos = 0;
		String broker = "ssl://cmw.ext.innovarail.indra.es:8883";
		String clientId = "331";
		String certificateName = "/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/public key/yard_planner.cert.pem";
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			SSLSocketFactory socketFactory = getSocketFactory(certificateName);
			connOpts.setSocketFactory(socketFactory);
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + broker);
			sampleClient.connect(connOpts);
			System.out.println("Connected");
			System.out.println("Publishing message: " + content);
			MqttMessage message = new MqttMessage(content.getBytes());
			message.setQos(qos);
			sampleClient.publish(topic, message);
			System.out.println("Message published");
			sampleClient.disconnect();
			System.out.println("Disconnected");
			System.exit(0);
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static SSLSocketFactory getSocketFactory(String certificateName) throws Exception {
		// Load the certificate from src/main/resources and create a Certificate object
		InputStream certStream = new FileInputStream(certificateName);
		CertificateFactory certFactory = CertificateFactory.getInstance("X509");
		Certificate certificate = certFactory.generateCertificate(certStream);
		SSLContext sslContext = SSLContext.getInstance("TLS");
		TrustManagerFactory trustManagerFactory = TrustManagerFactory
				.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		keyStore.load();
		keyStore.setCertificateEntry("alias", certificate);
		trustManagerFactory.init(keyStore);
		sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
		return sslContext.getSocketFactory();
	}

}