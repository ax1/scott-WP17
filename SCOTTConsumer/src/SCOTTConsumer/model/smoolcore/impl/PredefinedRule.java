
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
import SCOTTConsumer.model.smoolcore.IPredefinedRule;

/**
 * This class implements the ontology concept PredefinedRule
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */
public class PredefinedRule extends AbstractOntConcept implements IPredefinedRule, KPProducer, KPConsumer{

    //Not needed.. public static String CLASS_NAMESPACE = "http://com.tecnalia.smool/core/smoolcore#";
  	//Not needed.. public static String CLASS_ID = "PredefinedRule";
  	public static String CLASS_IRI = "http://com.tecnalia.smool/core/smoolcore#PredefinedRule"; 
  		
  		
  	/**
    * The Constructor
    */
    public PredefinedRule() {
    	super();
        init();
	}
    	
    	
	/**
 	* The Constructor
 	* @param id the Actuator identifier
 	*/
	public PredefinedRule(String id) {
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
    
      
      	// Creates the ruleID property
      	String ruleIDIRI = "http://com.tecnalia.smool/core/smoolcore#ruleID";
      	String ruleIDPrefix = "smoolcore";

      	FunctionalDatatypeSlot < String > ruleIDSlot= new FunctionalDatatypeSlot<String>(String.class);
      	ruleIDSlot._setIRI(ruleIDIRI);
      	ruleIDSlot._setPrefix(ruleIDPrefix);
      	ruleIDSlot.setRange("xsd:String");
      	this._addProperty(ruleIDSlot);
  	  
  	}
	/*
	* PROPERTIES: GETTERS AND SETTERS
	*/
 	
 	/**
 	* Sets the ruleID property.
 	* @param ruleID String value
 	*/
	public void setRuleID(String ruleID) {
		this.updateAttribute("ruleID",ruleID);        
	}
		
	 /**
 	* Gets the ruleID property.
 	* @return a String value
 	*/
	public String getRuleID() {
    	return (String) this._getFunctionalProperty("ruleID").getValue();
	}

}
