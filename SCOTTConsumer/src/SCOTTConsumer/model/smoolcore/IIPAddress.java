
/*******************************************************************************
* Copyright (c) 2012 Tecnalia Research and Innovation.
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
import SCOTTConsumer.model.smoolcore.ILogicalLocation;
       

/**
 * This class implements interface for the ontology concept IPAddress
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface IIPAddress extends IAbstractOntConcept, ILogicalLocation{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
 	/**
 	* Sets the dataID property.
 	* @param dataID String value
 	*/
 	public void setDataID(String dataID );

	/**
 	* Gets the dataID property.
 	* @return a String value
	*/
 	public String getDataID();

 	/**
 	* Sets the timestamp property.
 	* @param timestamp String value
 	*/
 	public void setTimestamp(String timestamp );

	/**
 	* Gets the timestamp property.
 	* @return a String value
	*/
 	public String getTimestamp();

 	/**
 	* Sets the logicalLoc property.
 	* @param logicalLoc ILogicalLocation value
 	*/
 	public void setLogicalLoc(ILogicalLocation logicalLoc );

	/**
 	* Gets the logicalLoc property.
 	* @return a ILogicalLocation value
	*/
 	public ILogicalLocation getLogicalLoc();
}
