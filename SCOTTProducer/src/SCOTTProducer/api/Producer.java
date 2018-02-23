
/*
 * Generated Producer interface
 */
package SCOTTProducer.api;


import org.smool.kpi.model.exception.KPIModelException;

import SCOTTProducer.model.smoolcore.*;

public interface Producer {

	/**
	 * Create method for the MessageReceiveSensor concept
	 * This method creates a new concept instance and publishes it
	 *
	 * @param elemID. The ID of the concept instance ID to be created.
	 * @param deviceID.
	 * @param vendor.
	 * @param alarms.
	 * @param destination.
	 * @param logicalLoc.
	 * @param message.
	 * @param origin.
	 * @return the ID of the generated concept instance.
	 * @throws KPIModelException if an error occurs during concept creation / publishing.
	 */
	public String createMessageReceiveSensor(String elemID, String deviceID, String vendor, java.util.List<IAlarm> alarms, java.util.List<ILogicalLocation> destination, ILogicalLocation logicalLoc, IMessage message, ILogicalLocation origin) throws KPIModelException;

	/**
	 * Update method for the MessageReceiveSensor concept
	 * This method updates an existing concept instance and publishes it
	 *
	 * @param elemID. The ID of the concept instance ID to be updated.
	 * @param deviceID.
	 * @param vendor.
	 * @param alarms.
	 * @param destination.
	 * @param logicalLoc.
	 * @param message.
	 * @param origin.
	 * @throws KPIModelException if an error occurs during concept update / publishing.
	 */
	public void updateMessageReceiveSensor(String elemID, String deviceID, String vendor, java.util.List<IAlarm> alarms, java.util.List<ILogicalLocation> destination, ILogicalLocation logicalLoc, IMessage message, ILogicalLocation origin) throws KPIModelException;

	/**
	 * Remove method for the MessageReceiveSensor concept
	 *
	 * @param elemID. The ID of the concept instance ID to be removed.
	 * @throws KPIModelException if an error occurs during concept removal.
	 */
	public void removeMessageReceiveSensor(String elemID) throws KPIModelException;

}
