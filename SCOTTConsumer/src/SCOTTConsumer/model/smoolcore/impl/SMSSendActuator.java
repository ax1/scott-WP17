
/*******************************************************************************
* Copyright (c) 2012 Tecnalia Research and Innovation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* This file is a result of OWL 2 java transformation using EMF
* Contributors:
*    Enas Ashraf (inas@itida.gov.eg) - creation of level 2 metamodel and transformation to java classes 
*    Adrian Noguero (Tecnalia Research and Innovation - Software Systems Engineering) - reation of level 1 metamodel by creating ...
*******************************************************************************/ 
package SCOTTConsumer.model.smoolcore.impl;
     
import org.smool.kpi.model.smart.AbstractOntConcept;
import org.smool.kpi.model.smart.KPProducer;
import org.smool.kpi.model.smart.KPConsumer;
import org.smool.kpi.model.smart.slots.FunctionalDatatypeSlot;
import org.smool.kpi.model.smart.slots.FunctionalObjectSlot;
import org.smool.kpi.model.smart.slots.NonFunctionalObjectSlot;
import SCOTTConsumer.model.smoolcore.ISMSSendActuator;
import SCOTTConsumer.model.smoolcore.IAlarm;
import SCOTTConsumer.model.smoolcore.impl.Alarm;
import SCOTTConsumer.model.smoolcore.ILogicalLocation;
import SCOTTConsumer.model.smoolcore.impl.LogicalLocation;
import SCOTTConsumer.model.smoolcore.IMessage;
import SCOTTConsumer.model.smoolcore.impl.Message;
import SCOTTConsumer.model.smoolcore.ITelephoneNumber;
import SCOTTConsumer.model.smoolcore.impl.TelephoneNumber;

/**
 * This class implements the ontology concept SMSSendActuator
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */
public class SMSSendActuator extends AbstractOntConcept implements ISMSSendActuator, KPProducer, KPConsumer{

    //Not needed.. public static String CLASS_NAMESPACE = "http://com.tecnalia.smool/core/smoolcore#";
  	//Not needed.. public static String CLASS_ID = "SMSSendActuator";
  	public static String CLASS_IRI = "http://com.tecnalia.smool/core/smoolcore#SMSSendActuator"; 
  		
  		
  	/**
    * The Constructor
    */
    public SMSSendActuator() {
    	super();
        init();
	}
    	
    	
	/**
 	* The Constructor
 	* @param id the Actuator identifier
 	*/
	public SMSSendActuator(String id) {
      	/** Call superclass to establish the identifier */
      	super(id);
      	init();
	}
    
    	
    	
	/**
 	* Inits the fields associated to a ontology concept
 	*/
	public void init() {
      	/** Sets the context of this ontology concept */
      	this._setClassContext("smoolcore", CLASS_IRI);

      	/** Sets the individual context */
      	this._setDefaultIndividualContext();
    
      
      	// Creates the deviceID property
      	String deviceIDIRI = "http://com.tecnalia.smool/core/smoolcore#deviceID";
      	String deviceIDPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > deviceIDSlot= new FunctionalDatatypeSlot<String>(String.class);
      	deviceIDSlot._setIRI(deviceIDIRI);
      	deviceIDSlot._setPrefix(deviceIDPrefix);
      	deviceIDSlot.setRange("xsd:String");
      	this._addProperty(deviceIDSlot);
  	  
  	  
      	// Creates the vendor property
      	String vendorIRI = "http://com.tecnalia.smool/core/smoolcore#vendor";
      	String vendorPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > vendorSlot= new FunctionalDatatypeSlot<String>(String.class);
      	vendorSlot._setIRI(vendorIRI);
      	vendorSlot._setPrefix(vendorPrefix);
      	vendorSlot.setRange("xsd:String");
      	this._addProperty(vendorSlot);
  	  
  	  
      	// Creates the alarms property
      	String alarmsIRI = "http://com.tecnalia.smool/core/smoolcore#alarms";
      	String alarmsPrefix = "smoolcore";

      	NonFunctionalObjectSlot < Alarm > alarmsSlot= new NonFunctionalObjectSlot<Alarm>(Alarm.class);
      	alarmsSlot._setIRI(alarmsIRI);
      	alarmsSlot._setPrefix(alarmsPrefix);
      	
      	this._addProperty(alarmsSlot);
  	  
  	  
      	// Creates the destination property
      	String destinationIRI = "http://com.tecnalia.smool/core/smoolcore#destination";
      	String destinationPrefix = "smoolcore";

      	NonFunctionalObjectSlot < LogicalLocation > destinationSlot= new NonFunctionalObjectSlot<LogicalLocation>(LogicalLocation.class);
      	destinationSlot._setIRI(destinationIRI);
      	destinationSlot._setPrefix(destinationPrefix);
      	
      	this._addProperty(destinationSlot);
  	  
  	  
      	// Creates the logicalLoc property
      	String logicalLocIRI = "http://com.tecnalia.smool/core/smoolcore#logicalLoc";
      	String logicalLocPrefix = "smoolcore";

      	FunctionalObjectSlot < LogicalLocation > logicalLocSlot= new FunctionalObjectSlot<LogicalLocation>(LogicalLocation.class);
      	logicalLocSlot._setIRI(logicalLocIRI);
      	logicalLocSlot._setPrefix(logicalLocPrefix);
      	
      	this._addProperty(logicalLocSlot);
  	  
  	  
      	// Creates the message property
      	String messageIRI = "http://com.tecnalia.smool/core/smoolcore#message";
      	String messagePrefix = "smoolcore";

      	FunctionalObjectSlot < Message > messageSlot= new FunctionalObjectSlot<Message>(Message.class);
      	messageSlot._setIRI(messageIRI);
      	messageSlot._setPrefix(messagePrefix);
      	
      	this._addProperty(messageSlot);
  	  
  	  
      	// Creates the origin property
      	String originIRI = "http://com.tecnalia.smool/core/smoolcore#origin";
      	String originPrefix = "smoolcore";

      	FunctionalObjectSlot < LogicalLocation > originSlot= new FunctionalObjectSlot<LogicalLocation>(LogicalLocation.class);
      	originSlot._setIRI(originIRI);
      	originSlot._setPrefix(originPrefix);
      	
      	this._addProperty(originSlot);
  	  
  	  
      	// Creates the smsFrom property
      	String smsFromIRI = "http://com.tecnalia.smool/core/smoolcore#smsFrom";
      	String smsFromPrefix = "smoolcore";

      	FunctionalObjectSlot < TelephoneNumber > smsFromSlot= new FunctionalObjectSlot<TelephoneNumber>(TelephoneNumber.class);
      	smsFromSlot._setIRI(smsFromIRI);
      	smsFromSlot._setPrefix(smsFromPrefix);
      	
      	this._addProperty(smsFromSlot);
  	  
  	  
      	// Creates the smsTo property
      	String smsToIRI = "http://com.tecnalia.smool/core/smoolcore#smsTo";
      	String smsToPrefix = "smoolcore";

      	NonFunctionalObjectSlot < TelephoneNumber > smsToSlot= new NonFunctionalObjectSlot<TelephoneNumber>(TelephoneNumber.class);
      	smsToSlot._setIRI(smsToIRI);
      	smsToSlot._setPrefix(smsToPrefix);
      	
      	this._addProperty(smsToSlot);
  	  
  	}
	/*
	* PROPERTIES: GETTERS AND SETTERS
	*/
 	
 	/**
 	* Sets the deviceID property.
 	* @param deviceID String value
 	*/
	public void setDeviceID(String deviceID) {
		this.updateAttribute("deviceID",deviceID);        
	}
		
	 /**
 	* Gets the deviceID property.
 	* @return a String value
 	*/
	public String getDeviceID() {
    	return (String) this._getFunctionalProperty("deviceID").getValue();
	}

 	/**
 	* Sets the vendor property.
 	* @param vendor String value
 	*/
	public void setVendor(String vendor) {
		this.updateAttribute("vendor",vendor);        
	}
		
	 /**
 	* Gets the vendor property.
 	* @return a String value
 	*/
	public String getVendor() {
    	return (String) this._getFunctionalProperty("vendor").getValue();
	}

 	/**
 	* Adds the alarms property.
 	* @param alarms IAlarm value to add
 	*/
	public void addAlarms(IAlarm alarms) {
	  
	  if (!this.containsAttribute("alarms",alarms)) {
            this.addAttribute("alarms",alarms);
        }
		
	}
		
	 /**
 	* Removes the alarms property.
 	* @param alarms IAlarm value to remove
 	*/
	public void removeAlarms(IAlarm alarms) {
	  if (this.containsAttribute("alarms",alarms)) {
            this.removeAttribute("alarms",alarms);
        }
    	
	}

 	/**
 	* Adds the destination property.
 	* @param destination ILogicalLocation value to add
 	*/
	public void addDestination(ILogicalLocation destination) {
	  
	  if (!this.containsAttribute("destination",destination)) {
            this.addAttribute("destination",destination);
        }
		
	}
		
	 /**
 	* Removes the destination property.
 	* @param destination ILogicalLocation value to remove
 	*/
	public void removeDestination(ILogicalLocation destination) {
	  if (this.containsAttribute("destination",destination)) {
            this.removeAttribute("destination",destination);
        }
    	
	}

 	/**
 	* Sets the logicalLoc property.
 	* @param logicalLoc ILogicalLocation value
 	*/
	public void setLogicalLoc(ILogicalLocation logicalLoc) {
		this.updateAttribute("logicalLoc",logicalLoc);        
	}
		
	 /**
 	* Gets the logicalLoc property.
 	* @return a ILogicalLocation value
 	*/
	public ILogicalLocation getLogicalLoc() {
    	return (ILogicalLocation) this._getFunctionalProperty("logicalLoc").getValue();
	}

 	/**
 	* Sets the message property.
 	* @param message IMessage value
 	*/
	public void setMessage(IMessage message) {
		this.updateAttribute("message",message);        
	}
		
	 /**
 	* Gets the message property.
 	* @return a IMessage value
 	*/
	public IMessage getMessage() {
    	return (IMessage) this._getFunctionalProperty("message").getValue();
	}

 	/**
 	* Sets the origin property.
 	* @param origin ILogicalLocation value
 	*/
	public void setOrigin(ILogicalLocation origin) {
		this.updateAttribute("origin",origin);        
	}
		
	 /**
 	* Gets the origin property.
 	* @return a ILogicalLocation value
 	*/
	public ILogicalLocation getOrigin() {
    	return (ILogicalLocation) this._getFunctionalProperty("origin").getValue();
	}

 	/**
 	* Sets the smsFrom property.
 	* @param smsFrom ITelephoneNumber value
 	*/
	public void setSmsFrom(ITelephoneNumber smsFrom) {
		this.updateAttribute("smsFrom",smsFrom);        
	}
		
	 /**
 	* Gets the smsFrom property.
 	* @return a ITelephoneNumber value
 	*/
	public ITelephoneNumber getSmsFrom() {
    	return (ITelephoneNumber) this._getFunctionalProperty("smsFrom").getValue();
	}

 	/**
 	* Adds the smsTo property.
 	* @param smsTo ITelephoneNumber value to add
 	*/
	public void addSmsTo(ITelephoneNumber smsTo) {
	  
	  if (!this.containsAttribute("smsTo",smsTo)) {
            this.addAttribute("smsTo",smsTo);
        }
		
	}
		
	 /**
 	* Removes the smsTo property.
 	* @param smsTo ITelephoneNumber value to remove
 	*/
	public void removeSmsTo(ITelephoneNumber smsTo) {
	  if (this.containsAttribute("smsTo",smsTo)) {
            this.removeAttribute("smsTo",smsTo);
        }
    	
	}

}
