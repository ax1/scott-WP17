
/*
 * Generated Consumer interface
 */
package SCOTTConsumer.api;


import org.smool.kpi.model.exception.KPIModelException;

import java.util.List;

import SCOTTConsumer.model.smoolcore.impl.*;

public interface Consumer {

	/**
	 * Subscribe to the MessageReceiveSensor concept
	 *
	 * @param subscription. The subscription object associated to the concept.
	 * @param individualID. An optional individual ID (might be null).
	 * @throws KPIModelException. If an error occurs during publishing.
	 */
	public void subscribeToMessageReceiveSensor(MessageReceiveSensorSubscription subscription, String individualID) throws KPIModelException;
	/**
	 * Unsubscribe to the MessageReceiveSensor concept
	 *
	 * @param subscription. The subscription object associated to the concept.
	 * @throws KPIModelException. If an error occurs during publishing.
	 */
	public void unsubscribeToMessageReceiveSensor(MessageReceiveSensorSubscription subscription) throws KPIModelException;
	/**
	 * Queries for all the MessageReceiveSensor concepts
	 *
	 * @return a list of all the individuals of the LightingSensor concept.
	 * @throws KPIModelException. If an error occurs during publishing.
	 */
	public List<MessageReceiveSensor> queryAllMessageReceiveSensor() throws KPIModelException;
	/**
	 * Queries for a single MessageReceiveSensor concept
	 *
	 * @param individualID. The ID of the queried individual.
	 * @return the concept individual or null.
	 * @throws KPIModelException. If an error occurs during publishing.
	 */
	public MessageReceiveSensor queryMessageReceiveSensor(String individualID) throws KPIModelException;

}
