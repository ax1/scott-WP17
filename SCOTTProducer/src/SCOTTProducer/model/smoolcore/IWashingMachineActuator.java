
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
       
import SCOTTProducer.model.smoolcore.IBooleanInformation;
       
import SCOTTProducer.model.smoolcore.IPhysicalLocation;
       
import SCOTTProducer.model.smoolcore.IProgrammeInformation;
       
import SCOTTProducer.model.smoolcore.ISecurity;
       

/**
 * This class implements interface for the ontology concept WashingMachineActuator
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface IWashingMachineActuator extends IAbstractOntConcept, IOnOffActuator, IProgrammableActuator{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
 	/**
 	* Sets the deviceID property.
 	* @param deviceID String value
 	*/
 	public IWashingMachineActuator setDeviceID(String deviceID );

	/**
 	* Gets the deviceID property.
 	* @return a String value
	*/
 	public String getDeviceID();

 	/**
 	* Sets the vendor property.
 	* @param vendor String value
 	*/
 	public IWashingMachineActuator setVendor(String vendor );

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
 	* Sets the bool property.
 	* @param bool IBooleanInformation value
 	*/
 	public IWashingMachineActuator setBool(IBooleanInformation bool );

	/**
 	* Gets the bool property.
 	* @return a IBooleanInformation value
	*/
 	public IBooleanInformation getBool();

 	/**
 	* Sets the physicalLoc property.
 	* @param physicalLoc IPhysicalLocation value
 	*/
 	public IWashingMachineActuator setPhysicalLoc(IPhysicalLocation physicalLoc );

	/**
 	* Gets the physicalLoc property.
 	* @return a IPhysicalLocation value
	*/
 	public IPhysicalLocation getPhysicalLoc();

 	/**
 	* Sets the programme property.
 	* @param programme IProgrammeInformation value
 	*/
 	public IWashingMachineActuator setProgramme(IProgrammeInformation programme );

	/**
 	* Gets the programme property.
 	* @return a IProgrammeInformation value
	*/
 	public IProgrammeInformation getProgramme();

 	/**
 	* Sets the securityData property.
 	* @param securityData ISecurity value
 	*/
 	public IWashingMachineActuator setSecurityData(ISecurity securityData );

	/**
 	* Gets the securityData property.
 	* @return a ISecurity value
	*/
 	public ISecurity getSecurityData();
}
