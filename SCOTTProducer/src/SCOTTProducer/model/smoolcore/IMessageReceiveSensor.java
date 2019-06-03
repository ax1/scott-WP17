
/*******************************************************************************
* Copyright (c) 2018 Tecnalia Research and Innovation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* This file is a result of OWL 2 java transformation using EMF
* 
* Generated by SMOOL SDK Wizard
*******************************************************************************/ 
package SCOTTProducer.model.smoolcore;
       
import org.smool.kpi.model.smart.IAbstractOntConcept;
import SCOTTProducer.model.smoolcore.IAlarm;
       
import SCOTTProducer.model.smoolcore.ILogicalLocation;
       
import SCOTTProducer.model.smoolcore.IMessage;
       
import SCOTTProducer.model.smoolcore.ISecurity;
       

/**
 * This class implements interface for the ontology concept MessageReceiveSensor
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface IMessageReceiveSensor extends IAbstractOntConcept, ILogicalSensor{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
 	/**
 	* Sets the deviceID property.
 	* @param deviceID String value
 	*/
 	public IMessageReceiveSensor setDeviceID(String deviceID );

	/**
 	* Gets the deviceID property.
 	* @return a String value
	*/
 	public String getDeviceID();

 	/**
 	* Sets the vendor property.
 	* @param vendor String value
 	*/
 	public IMessageReceiveSensor setVendor(String vendor );

	/**
 	* Gets the vendor property.
 	* @return a String value
	*/
 	public String getVendor();

 	/**
 	* Adds the alarms property.
 	* @param alarms IAlarm value to add
 	*/
 	public void addAlarms(IAlarm alarms );

	/**
 	* Removes the alarms property.
 	* @param alarms IAlarm value to remove
	*/
 	public void removeAlarms(IAlarm alarms );

 	/**
 	* Adds the destination property.
 	* @param destination ILogicalLocation value to add
 	*/
 	public void addDestination(ILogicalLocation destination );

	/**
 	* Removes the destination property.
 	* @param destination ILogicalLocation value to remove
	*/
 	public void removeDestination(ILogicalLocation destination );

 	/**
 	* Sets the logicalLoc property.
 	* @param logicalLoc ILogicalLocation value
 	*/
 	public IMessageReceiveSensor setLogicalLoc(ILogicalLocation logicalLoc );

	/**
 	* Gets the logicalLoc property.
 	* @return a ILogicalLocation value
	*/
 	public ILogicalLocation getLogicalLoc();

 	/**
 	* Sets the message property.
 	* @param message IMessage value
 	*/
 	public IMessageReceiveSensor setMessage(IMessage message );

	/**
 	* Gets the message property.
 	* @return a IMessage value
	*/
 	public IMessage getMessage();

 	/**
 	* Sets the origin property.
 	* @param origin ILogicalLocation value
 	*/
 	public IMessageReceiveSensor setOrigin(ILogicalLocation origin );

	/**
 	* Gets the origin property.
 	* @return a ILogicalLocation value
	*/
 	public ILogicalLocation getOrigin();

 	/**
 	* Sets the securityData property.
 	* @param securityData ISecurity value
 	*/
 	public IMessageReceiveSensor setSecurityData(ISecurity securityData );

	/**
 	* Gets the securityData property.
 	* @return a ISecurity value
	*/
 	public ISecurity getSecurityData();
}
