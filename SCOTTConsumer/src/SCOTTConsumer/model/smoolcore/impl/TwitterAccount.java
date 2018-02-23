
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
import SCOTTConsumer.model.smoolcore.ITwitterAccount;
import SCOTTConsumer.model.smoolcore.ILogicalLocation;
import SCOTTConsumer.model.smoolcore.impl.LogicalLocation;

/**
 * This class implements the ontology concept TwitterAccount
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */
public class TwitterAccount extends AbstractOntConcept implements ITwitterAccount, KPProducer, KPConsumer{

    //Not needed.. public static String CLASS_NAMESPACE = "http://com.tecnalia.smool/core/smoolcore#";
  	//Not needed.. public static String CLASS_ID = "TwitterAccount";
  	public static String CLASS_IRI = "http://com.tecnalia.smool/core/smoolcore#TwitterAccount"; 
  		
  		
  	/**
    * The Constructor
    */
    public TwitterAccount() {
    	super();
        init();
	}
    	
    	
	/**
 	* The Constructor
 	* @param id the Actuator identifier
 	*/
	public TwitterAccount(String id) {
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
  	  
  	  
      	// Creates the password property
      	String passwordIRI = "http://com.tecnalia.smool/core/smoolcore#password";
      	String passwordPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > passwordSlot= new FunctionalDatatypeSlot<String>(String.class);
      	passwordSlot._setIRI(passwordIRI);
      	passwordSlot._setPrefix(passwordPrefix);
      	passwordSlot.setRange("xsd:String");
      	this._addProperty(passwordSlot);
  	  
  	  
      	// Creates the timestamp property
      	String timestampIRI = "http://com.tecnalia.smool/core/smoolcore#timestamp";
      	String timestampPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > timestampSlot= new FunctionalDatatypeSlot<String>(String.class);
      	timestampSlot._setIRI(timestampIRI);
      	timestampSlot._setPrefix(timestampPrefix);
      	timestampSlot.setRange("xsd:String");
      	this._addProperty(timestampSlot);
  	  
  	  
      	// Creates the username property
      	String usernameIRI = "http://com.tecnalia.smool/core/smoolcore#username";
      	String usernamePrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > usernameSlot= new FunctionalDatatypeSlot<String>(String.class);
      	usernameSlot._setIRI(usernameIRI);
      	usernameSlot._setPrefix(usernamePrefix);
      	usernameSlot.setRange("xsd:String");
      	this._addProperty(usernameSlot);
  	  
  	  
      	// Creates the logicalLoc property
      	String logicalLocIRI = "http://com.tecnalia.smool/core/smoolcore#logicalLoc";
      	String logicalLocPrefix = "smoolcore";

      	FunctionalObjectSlot < LogicalLocation > logicalLocSlot= new FunctionalObjectSlot<LogicalLocation>(LogicalLocation.class);
      	logicalLocSlot._setIRI(logicalLocIRI);
      	logicalLocSlot._setPrefix(logicalLocPrefix);
      	
      	this._addProperty(logicalLocSlot);
  	  
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
 	* Sets the password property.
 	* @param password String value
 	*/
	public void setPassword(String password) {
		this.updateAttribute("password",password);        
	}
		
	 /**
 	* Gets the password property.
 	* @return a String value
 	*/
	public String getPassword() {
    	return (String) this._getFunctionalProperty("password").getValue();
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
 	* Sets the username property.
 	* @param username String value
 	*/
	public void setUsername(String username) {
		this.updateAttribute("username",username);        
	}
		
	 /**
 	* Gets the username property.
 	* @return a String value
 	*/
	public String getUsername() {
    	return (String) this._getFunctionalProperty("username").getValue();
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

}
