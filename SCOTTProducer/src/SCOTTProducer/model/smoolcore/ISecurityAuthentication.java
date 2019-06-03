
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
 * This class implements interface for the ontology concept SecurityAuthentication
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface ISecurityAuthentication extends IAbstractOntConcept, ISecurity{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
 	/**
 	* Sets the data property.
 	* @param data String value
 	*/
 	public ISecurityAuthentication setData(String data );

	/**
 	* Gets the data property.
 	* @return a String value
	*/
 	public String getData();

 	/**
 	* Sets the dataID property.
 	* @param dataID String value
 	*/
 	public ISecurityAuthentication setDataID(String dataID );

	/**
 	* Gets the dataID property.
 	* @return a String value
	*/
 	public String getDataID();

 	/**
 	* Sets the timestamp property.
 	* @param timestamp String value
 	*/
 	public ISecurityAuthentication setTimestamp(String timestamp );

	/**
 	* Gets the timestamp property.
 	* @return a String value
	*/
 	public String getTimestamp();

 	/**
 	* Sets the type property.
 	* @param type String value
 	*/
 	public ISecurityAuthentication setType(String type );

	/**
 	* Gets the type property.
 	* @return a String value
	*/
 	public String getType();
}
