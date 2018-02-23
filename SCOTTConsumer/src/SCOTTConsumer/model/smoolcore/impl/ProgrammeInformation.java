
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
import SCOTTConsumer.model.smoolcore.IProgrammeInformation;

/**
 * This class implements the ontology concept ProgrammeInformation
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */
public class ProgrammeInformation extends AbstractOntConcept implements IProgrammeInformation, KPProducer, KPConsumer{

    //Not needed.. public static String CLASS_NAMESPACE = "http://com.tecnalia.smool/core/smoolcore#";
  	//Not needed.. public static String CLASS_ID = "ProgrammeInformation";
  	public static String CLASS_IRI = "http://com.tecnalia.smool/core/smoolcore#ProgrammeInformation"; 
  		
  		
  	/**
    * The Constructor
    */
    public ProgrammeInformation() {
    	super();
        init();
	}
    	
    	
	/**
 	* The Constructor
 	* @param id the Actuator identifier
 	*/
	public ProgrammeInformation(String id) {
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
  	  
  	  
      	// Creates the end property
      	String endIRI = "http://com.tecnalia.smool/core/smoolcore#end";
      	String endPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > endSlot= new FunctionalDatatypeSlot<String>(String.class);
      	endSlot._setIRI(endIRI);
      	endSlot._setPrefix(endPrefix);
      	endSlot.setRange("xsd:String");
      	this._addProperty(endSlot);
  	  
  	  
      	// Creates the start property
      	String startIRI = "http://com.tecnalia.smool/core/smoolcore#start";
      	String startPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > startSlot= new FunctionalDatatypeSlot<String>(String.class);
      	startSlot._setIRI(startIRI);
      	startSlot._setPrefix(startPrefix);
      	startSlot.setRange("xsd:String");
      	this._addProperty(startSlot);
  	  
  	  
      	// Creates the timestamp property
      	String timestampIRI = "http://com.tecnalia.smool/core/smoolcore#timestamp";
      	String timestampPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > timestampSlot= new FunctionalDatatypeSlot<String>(String.class);
      	timestampSlot._setIRI(timestampIRI);
      	timestampSlot._setPrefix(timestampPrefix);
      	timestampSlot.setRange("xsd:String");
      	this._addProperty(timestampSlot);
  	  
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
 	* Sets the end property.
 	* @param end String value
 	*/
	public void setEnd(String end) {
		this.updateAttribute("end",end);        
	}
		
	 /**
 	* Gets the end property.
 	* @return a String value
 	*/
	public String getEnd() {
    	return (String) this._getFunctionalProperty("end").getValue();
	}

 	/**
 	* Sets the start property.
 	* @param start String value
 	*/
	public void setStart(String start) {
		this.updateAttribute("start",start);        
	}
		
	 /**
 	* Gets the start property.
 	* @return a String value
 	*/
	public String getStart() {
    	return (String) this._getFunctionalProperty("start").getValue();
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

}
