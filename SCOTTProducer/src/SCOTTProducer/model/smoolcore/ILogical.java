
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
 * This class implements interface for the ontology concept Logical
 * including all its properties.
 * @author Genrated via EMF OWL to java transformation
 * @version 1.0
 */

public interface ILogical extends IAbstractOntConcept, INature{

   /*
 	* PROPERTIES: GETTERS AND SETTERS
 	*/
   
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
