
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
package SCOTTConsumer.model.smoolcore;
       
import org.smool.kpi.model.smart.IAbstractOntConcept;

/**
 * This class implements interface for the ontology concept GisLocation
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface IGisLocation extends IAbstractOntConcept, IPhysicalLocation{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
 	/**
 	* Sets the dataID property.
 	* @param dataID String value
 	*/
 	public IGisLocation setDataID(String dataID );

	/**
 	* Gets the dataID property.
 	* @return a String value
	*/
 	public String getDataID();

 	/**
 	* Sets the latitude property.
 	* @param latitude Double value
 	*/
 	public IGisLocation setLatitude(Double latitude );

	/**
 	* Gets the latitude property.
 	* @return a Double value
	*/
 	public Double getLatitude();

 	/**
 	* Sets the longitude property.
 	* @param longitude Double value
 	*/
 	public IGisLocation setLongitude(Double longitude );

	/**
 	* Gets the longitude property.
 	* @return a Double value
	*/
 	public Double getLongitude();

 	/**
 	* Sets the timestamp property.
 	* @param timestamp String value
 	*/
 	public IGisLocation setTimestamp(String timestamp );

	/**
 	* Gets the timestamp property.
 	* @return a String value
	*/
 	public String getTimestamp();
}
