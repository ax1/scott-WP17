
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
import SCOTTProducer.model.smoolcore.ITemperatureInformation;

/**
 * This class implements the ontology concept TemperatureInformation
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */
public class TemperatureInformation extends AbstractOntConcept implements ITemperatureInformation, KPProducer, KPConsumer{

    //Not needed.. public static String CLASS_NAMESPACE = "http://com.tecnalia.smool/core/smoolcore#";
  	//Not needed.. public static String CLASS_ID = "TemperatureInformation";
  	public static String CLASS_IRI = "http://com.tecnalia.smool/core/smoolcore#TemperatureInformation"; 
  		
  		
  	/**
    * The Constructor
    */
    public TemperatureInformation() {
    	super();
        init();
	}
    	
    	
	/**
 	* The Constructor
 	* @param id the Actuator identifier
 	*/
	public TemperatureInformation(String id) {
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
  	  
  	  
      	// Creates the tempUnit property
      	String tempUnitIRI = "http://com.tecnalia.smool/core/smoolcore#tempUnit";
      	String tempUnitPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > tempUnitSlot= new FunctionalDatatypeSlot<String>(String.class);
      	tempUnitSlot._setIRI(tempUnitIRI);
      	tempUnitSlot._setPrefix(tempUnitPrefix);
      	tempUnitSlot.setRange("xsd:String");
      	this._addProperty(tempUnitSlot);
  	  
  	  
      	// Creates the tempValue property
      	String tempValueIRI = "http://com.tecnalia.smool/core/smoolcore#tempValue";
      	String tempValuePrefix = "smoolcore";

      	FunctionalDatatypeSlot < Double > tempValueSlot= new FunctionalDatatypeSlot<Double>(Double.class);
      	tempValueSlot._setIRI(tempValueIRI);
      	tempValueSlot._setPrefix(tempValuePrefix);
      	tempValueSlot.setRange("xsd:Double");
      	this._addProperty(tempValueSlot);
  	  
  	  
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
 	* Sets the tempUnit property.
 	* @param tempUnit String value
 	*/
	public void setTempUnit(String tempUnit) {
		this.updateAttribute("tempUnit",tempUnit);        
	}
		
	 /**
 	* Gets the tempUnit property.
 	* @return a String value
 	*/
	public String getTempUnit() {
    	return (String) this._getFunctionalProperty("tempUnit").getValue();
	}

 	/**
 	* Sets the tempValue property.
 	* @param tempValue Double value
 	*/
	public void setTempValue(Double tempValue) {
		this.updateAttribute("tempValue",tempValue);        
	}
		
	 /**
 	* Gets the tempValue property.
 	* @return a Double value
 	*/
	public Double getTempValue() {
    	return (Double) this._getFunctionalProperty("tempValue").getValue();
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
