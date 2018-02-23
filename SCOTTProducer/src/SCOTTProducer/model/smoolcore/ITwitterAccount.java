
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
package SCOTTProducer.model.smoolcore;
       
import org.smool.kpi.model.smart.IAbstractOntConcept;
import SCOTTProducer.model.smoolcore.ILogicalLocation;
       

/**
 * This class implements interface for the ontology concept TwitterAccount
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface ITwitterAccount extends IAbstractOntConcept, IServiceAccount{

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
 	* Sets the password property.
 	* @param password String value
 	*/
 	public void setPassword(String password );

	/**
 	* Gets the password property.
 	* @return a String value
	*/
 	public String getPassword();

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
 	* Sets the username property.
 	* @param username String value
 	*/
 	public void setUsername(String username );

	/**
 	* Gets the username property.
 	* @return a String value
	*/
 	public String getUsername();

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
