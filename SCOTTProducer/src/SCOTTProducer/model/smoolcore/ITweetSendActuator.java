
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
       
import SCOTTProducer.model.smoolcore.ITwitterAccount;
       

/**
 * This class implements interface for the ontology concept TweetSendActuator
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface ITweetSendActuator extends IAbstractOntConcept, IMessageSendActuator{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
 	/**
 	* Sets the deviceID property.
 	* @param deviceID String value
 	*/
 	public ITweetSendActuator setDeviceID(String deviceID );

	/**
 	* Gets the deviceID property.
 	* @return a String value
	*/
 	public String getDeviceID();

 	/**
 	* Sets the vendor property.
 	* @param vendor String value
 	*/
 	public ITweetSendActuator setVendor(String vendor );

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
 	public ITweetSendActuator setLogicalLoc(ILogicalLocation logicalLoc );

	/**
 	* Gets the logicalLoc property.
 	* @return a ILogicalLocation value
	*/
 	public ILogicalLocation getLogicalLoc();

 	/**
 	* Sets the message property.
 	* @param message IMessage value
 	*/
 	public ITweetSendActuator setMessage(IMessage message );

	/**
 	* Gets the message property.
 	* @return a IMessage value
	*/
 	public IMessage getMessage();

 	/**
 	* Sets the origin property.
 	* @param origin ILogicalLocation value
 	*/
 	public ITweetSendActuator setOrigin(ILogicalLocation origin );

	/**
 	* Gets the origin property.
 	* @return a ILogicalLocation value
	*/
 	public ILogicalLocation getOrigin();

 	/**
 	* Sets the securityData property.
 	* @param securityData ISecurity value
 	*/
 	public ITweetSendActuator setSecurityData(ISecurity securityData );

	/**
 	* Gets the securityData property.
 	* @return a ISecurity value
	*/
 	public ISecurity getSecurityData();

 	/**
 	* Sets the tweetWriter property.
 	* @param tweetWriter ITwitterAccount value
 	*/
 	public ITweetSendActuator setTweetWriter(ITwitterAccount tweetWriter );

	/**
 	* Gets the tweetWriter property.
 	* @return a ITwitterAccount value
	*/
 	public ITwitterAccount getTweetWriter();
}
