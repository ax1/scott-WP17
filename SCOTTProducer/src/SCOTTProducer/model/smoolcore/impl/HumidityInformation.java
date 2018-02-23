
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
package SCOTTProducer.model.smoolcore.impl;
     
import org.smool.kpi.model.smart.AbstractOntConcept;
import org.smool.kpi.model.smart.KPProducer;
import org.smool.kpi.model.smart.KPConsumer;
import org.smool.kpi.model.smart.slots.FunctionalDatatypeSlot;
import SCOTTProducer.model.smoolcore.IHumidityInformation;

/**
 * This class implements the ontology concept HumidityInformation
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */
public class HumidityInformation extends AbstractOntConcept implements IHumidityInformation, KPProducer, KPConsumer{

    //Not needed.. public static String CLASS_NAMESPACE = "http://com.tecnalia.smool/core/smoolcore#";
  	//Not needed.. public static String CLASS_ID = "HumidityInformation";
  	public static String CLASS_IRI = "http://com.tecnalia.smool/core/smoolcore#HumidityInformation"; 
  		
  		
  	/**
    * The Constructor
    */
    public HumidityInformation() {
    	super();
        init();
	}
    	
    	
	/**
 	* The Constructor
 	* @param id the Actuator identifier
 	*/
	public HumidityInformation(String id) {
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
    
      
      	// Creates the dataID property
      	String dataIDIRI = "http://com.tecnalia.smool/core/smoolcore#dataID";
      	String dataIDPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > dataIDSlot= new FunctionalDatatypeSlot<String>(String.class);
      	dataIDSlot._setIRI(dataIDIRI);
      	dataIDSlot._setPrefix(dataIDPrefix);
      	dataIDSlot.setRange("xsd:String");
      	this._addProperty(dataIDSlot);
  	  
  	  
      	// Creates the humidityUnit property
      	String humidityUnitIRI = "http://com.tecnalia.smool/core/smoolcore#humidityUnit";
      	String humidityUnitPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > humidityUnitSlot= new FunctionalDatatypeSlot<String>(String.class);
      	humidityUnitSlot._setIRI(humidityUnitIRI);
      	humidityUnitSlot._setPrefix(humidityUnitPrefix);
      	humidityUnitSlot.setRange("xsd:String");
      	this._addProperty(humidityUnitSlot);
  	  
  	  
      	// Creates the humidityValue property
      	String humidityValueIRI = "http://com.tecnalia.smool/core/smoolcore#humidityValue";
      	String humidityValuePrefix = "smoolcore";

      	FunctionalDatatypeSlot < Double > humidityValueSlot= new FunctionalDatatypeSlot<Double>(Double.class);
      	humidityValueSlot._setIRI(humidityValueIRI);
      	humidityValueSlot._setPrefix(humidityValuePrefix);
      	humidityValueSlot.setRange("xsd:Double");
      	this._addProperty(humidityValueSlot);
  	  
  	  
      	// Creates the timestamp property
      	String timestampIRI = "http://com.tecnalia.smool/core/smoolcore#timestamp";
      	String timestampPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > timestampSlot= new FunctionalDatatypeSlot<String>(String.class);
      	timestampSlot._setIRI(timestampIRI);
      	timestampSlot._setPrefix(timestampPrefix);
      	timestampSlot.setRange("xsd:String");
      	this._addProperty(timestampSlot);
  	  
  	  
      	// Creates the unit property
      	String unitIRI = "http://com.tecnalia.smool/core/smoolcore#unit";
      	String unitPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > unitSlot= new FunctionalDatatypeSlot<String>(String.class);
      	unitSlot._setIRI(unitIRI);
      	unitSlot._setPrefix(unitPrefix);
      	unitSlot.setRange("xsd:String");
      	this._addProperty(unitSlot);
  	  
  	}
	/*
	* PROPERTIES: GETTERS AND SETTERS
	*/
 	
 	/**
 	* Sets the dataID property.
 	* @param dataID String value
 	*/
	public void setDataID(String dataID) {
		this.updateAttribute("dataID",dataID);        
	}
		
	 /**
 	* Gets the dataID property.
 	* @return a String value
 	*/
	public String getDataID() {
    	return (String) this._getFunctionalProperty("dataID").getValue();
	}

 	/**
 	* Sets the humidityUnit property.
 	* @param humidityUnit String value
 	*/
	public void setHumidityUnit(String humidityUnit) {
		this.updateAttribute("humidityUnit",humidityUnit);        
	}
		
	 /**
 	* Gets the humidityUnit property.
 	* @return a String value
 	*/
	public String getHumidityUnit() {
    	return (String) this._getFunctionalProperty("humidityUnit").getValue();
	}

 	/**
 	* Sets the humidityValue property.
 	* @param humidityValue Double value
 	*/
	public void setHumidityValue(Double humidityValue) {
		this.updateAttribute("humidityValue",humidityValue);        
	}
		
	 /**
 	* Gets the humidityValue property.
 	* @return a Double value
 	*/
	public Double getHumidityValue() {
    	return (Double) this._getFunctionalProperty("humidityValue").getValue();
	}

 	/**
 	* Sets the timestamp property.
 	* @param timestamp String value
 	*/
	public void setTimestamp(String timestamp) {
		this.updateAttribute("timestamp",timestamp);        
	}
		
	 /**
 	* Gets the timestamp property.
 	* @return a String value
 	*/
	public String getTimestamp() {
    	return (String) this._getFunctionalProperty("timestamp").getValue();
	}

 	/**
 	* Sets the unit property.
 	* @param unit String value
 	*/
	public void setUnit(String unit) {
		this.updateAttribute("unit",unit);        
	}
		
	 /**
 	* Gets the unit property.
 	* @return a String value
 	*/
	public String getUnit() {
    	return (String) this._getFunctionalProperty("unit").getValue();
	}

}
