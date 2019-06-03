
/*******************************************************************************
* Copyright (c) 2018 Tecnalia Research and Innovation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* This file is a result of OWL 2 java transformation using EMF
* Contributors:
*    Enas Ashraf (inas@itida.gov.eg) - creation of level 2 metamodel and transformation to java classes 
*    Adrian Noguero (Tecnalia Research and Innovation - Software Systems Engineering) - creation of level 1 metamodel by creating ...
*******************************************************************************/ 
package SCOTTProducer.model.smoolcore.impl;
     
import org.smool.kpi.model.smart.AbstractOntConcept;
import org.smool.kpi.model.smart.KPProducer;
import org.smool.kpi.model.smart.KPConsumer;
import org.smool.kpi.model.smart.slots.FunctionalDatatypeSlot;
import org.smool.kpi.model.smart.slots.FunctionalObjectSlot;
import org.smool.kpi.model.smart.slots.NonFunctionalObjectSlot;
import SCOTTProducer.model.smoolcore.ILocationSensor;
import SCOTTProducer.model.smoolcore.IAlarm;
import SCOTTProducer.model.smoolcore.impl.Alarm;
import SCOTTProducer.model.smoolcore.IPhysicalLocation;
import SCOTTProducer.model.smoolcore.impl.PhysicalLocation;
import SCOTTProducer.model.smoolcore.ISecurity;
import SCOTTProducer.model.smoolcore.impl.Security;

/**
 * This class implements the ontology concept LocationSensor
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */
public class LocationSensor extends AbstractOntConcept implements ILocationSensor, KPProducer, KPConsumer{

    //Not needed.. public static String CLASS_NAMESPACE = "http://com.tecnalia.smool/core/smoolcore#";
  	//Not needed.. public static String CLASS_ID = "LocationSensor";
  	public static String CLASS_IRI = "http://com.tecnalia.smool/core/smoolcore#LocationSensor"; 
  		
  		
  	/**
    * The Constructor
    */
    public LocationSensor() {
    	super();
        init();
	}
    	
    	
	/**
 	* The Constructor
 	* @param id the Actuator identifier
 	*/
	public LocationSensor(String id) {
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
  	  
  	  
      	// Creates the location property
      	String locationIRI = "http://com.tecnalia.smool/core/smoolcore#location";
      	String locationPrefix = "smoolcore";

      	FunctionalObjectSlot < PhysicalLocation > locationSlot= new FunctionalObjectSlot<PhysicalLocation>(PhysicalLocation.class);
      	locationSlot._setIRI(locationIRI);
      	locationSlot._setPrefix(locationPrefix);
      	
      	this._addProperty(locationSlot);
  	  
  	  
      	// Creates the physicalLoc property
      	String physicalLocIRI = "http://com.tecnalia.smool/core/smoolcore#physicalLoc";
      	String physicalLocPrefix = "smoolcore";

      	FunctionalObjectSlot < PhysicalLocation > physicalLocSlot= new FunctionalObjectSlot<PhysicalLocation>(PhysicalLocation.class);
      	physicalLocSlot._setIRI(physicalLocIRI);
      	physicalLocSlot._setPrefix(physicalLocPrefix);
      	
      	this._addProperty(physicalLocSlot);
  	  
  	  
      	// Creates the securityData property
      	String securityDataIRI = "http://com.tecnalia.smool/core/smoolcore#securityData";
      	String securityDataPrefix = "smoolcore";

      	FunctionalObjectSlot < Security > securityDataSlot= new FunctionalObjectSlot<Security>(Security.class);
      	securityDataSlot._setIRI(securityDataIRI);
      	securityDataSlot._setPrefix(securityDataPrefix);
      	
      	this._addProperty(securityDataSlot);
  	  
  	}
	/*
	* PROPERTIES: GETTERS AND SETTERS
	*/
 	
 	/**
 	* Sets the deviceID property.
 	* @param deviceID String value
 	*/
	public LocationSensor setDeviceID(String deviceID) {
		this.updateAttribute("deviceID",deviceID);
		return this;        
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
	public LocationSensor setVendor(String vendor) {
		this.updateAttribute("vendor",vendor);
		return this;        
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
 	* Sets the location property.
 	* @param location IPhysicalLocation value
 	*/
	public LocationSensor setLocation(IPhysicalLocation location) {
		this.updateAttribute("location",location);
		return this;        
	}
		
	 /**
 	* Gets the location property.
 	* @return a IPhysicalLocation value
 	*/
	public IPhysicalLocation getLocation() {
    	return (IPhysicalLocation) this._getFunctionalProperty("location").getValue();
	}

 	/**
 	* Sets the physicalLoc property.
 	* @param physicalLoc IPhysicalLocation value
 	*/
	public LocationSensor setPhysicalLoc(IPhysicalLocation physicalLoc) {
		this.updateAttribute("physicalLoc",physicalLoc);
		return this;        
	}
		
	 /**
 	* Gets the physicalLoc property.
 	* @return a IPhysicalLocation value
 	*/
	public IPhysicalLocation getPhysicalLoc() {
    	return (IPhysicalLocation) this._getFunctionalProperty("physicalLoc").getValue();
	}

 	/**
 	* Sets the securityData property.
 	* @param securityData ISecurity value
 	*/
	public LocationSensor setSecurityData(ISecurity securityData) {
		this.updateAttribute("securityData",securityData);
		return this;        
	}
		
	 /**
 	* Gets the securityData property.
 	* @return a ISecurity value
 	*/
	public ISecurity getSecurityData() {
    	return (ISecurity) this._getFunctionalProperty("securityData").getValue();
	}

}
