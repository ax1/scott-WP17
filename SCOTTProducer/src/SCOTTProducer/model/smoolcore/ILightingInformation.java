
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

/**
 * This class implements interface for the ontology concept LightingInformation
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface ILightingInformation extends IAbstractOntConcept, IContinuousInformation{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
 	/**
 	* Sets the dataID property.
 	* @param dataID String value
 	*/
 	public ILightingInformation setDataID(String dataID );

	/**
 	* Gets the dataID property.
 	* @return a String value
	*/
 	public String getDataID();

 	/**
 	* Sets the lightUnit property.
 	* @param lightUnit String value
 	*/
 	public ILightingInformation setLightUnit(String lightUnit );

	/**
 	* Gets the lightUnit property.
 	* @return a String value
	*/
 	public String getLightUnit();

 	/**
 	* Sets the lightValue property.
 	* @param lightValue Double value
 	*/
 	public ILightingInformation setLightValue(Double lightValue );

	/**
 	* Gets the lightValue property.
 	* @return a Double value
	*/
 	public Double getLightValue();

 	/**
 	* Sets the timestamp property.
 	* @param timestamp String value
 	*/
 	public ILightingInformation setTimestamp(String timestamp );

	/**
 	* Gets the timestamp property.
 	* @return a String value
	*/
 	public String getTimestamp();

 	/**
 	* Sets the unit property.
 	* @param unit String value
 	*/
 	public ILightingInformation setUnit(String unit );

	/**
 	* Gets the unit property.
 	* @return a String value
	*/
 	public String getUnit();

 	/**
 	* Sets the value property.
 	* @param value Double value
 	*/
 	public ILightingInformation setValue(Double value );

	/**
 	* Gets the value property.
 	* @return a Double value
	*/
 	public Double getValue();
}
