
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
 * This class implements interface for the ontology concept Information
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface IInformation extends IAbstractOntConcept, IData{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
 	/**
 	* Sets the dataID property.
 	* @param dataID String value
 	*/
 	public IInformation setDataID(String dataID );

	/**
 	* Gets the dataID property.
 	* @return a String value
	*/
 	public String getDataID();

 	/**
 	* Sets the timestamp property.
 	* @param timestamp String value
 	*/
 	public IInformation setTimestamp(String timestamp );

	/**
 	* Gets the timestamp property.
 	* @return a String value
	*/
 	public String getTimestamp();
}
