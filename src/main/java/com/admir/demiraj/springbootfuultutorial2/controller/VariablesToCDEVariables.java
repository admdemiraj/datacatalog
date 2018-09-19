/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.controller;

import com.admir.demiraj.springbootfuultutorial2.dao.FunctionsDAO;
import com.admir.demiraj.springbootfuultutorial2.dao.HospitalDAO;
import com.admir.demiraj.springbootfuultutorial2.dao.VariableDAO;
import com.admir.demiraj.springbootfuultutorial2.dao.VersionDAO;
import com.admir.demiraj.springbootfuultutorial2.resources.Functions;
import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import com.admir.demiraj.springbootfuultutorial2.resources.Versions;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
@RequestMapping("/mapping")
public class VariablesToCDEVariables {
    @Autowired
    private VariableDAO variableDAO;
    
    @Autowired
    private VersionDAO versionDAO;
    
   @Autowired
   private HospitalDAO hospitalDAO;
    
   @Autowired
   private FunctionsDAO functionsDAO;
   
   
   @PostMapping("/variables/{variable_id}")
   public List<Variables> getVariablesForEachMapping(@PathVariable(value="variable_id") Long variableId){
       return variableDAO.variablesToCdeVariables(variableId);

   }
   
    //save variables
    @GetMapping("/variables")
    public void saveVariable(){
        Versions ver = new Versions("version 1");
        versionDAO.saveVersion(ver);
        
        Hospitals hosp = new Hospitals("hospital 1");
        hospitalDAO.save(hosp);
        
        ///////////////////  2 DIFFRENT CASES FOR CREATING VARIABLES  //////////
        
        ///// CASE 1: One function for multiple variables //////// 
        Functions function1 = new Functions("turn 0 to F, turn 1 to M","rule description 1");
        functionsDAO.save(function1);
        
        for(int i=0;i<3;i++){
        Variables var = new Variables("variable "+i+3,"variable description "+i+3,"type "+i+3);
        variableDAO.saveVersionToVariable(var, ver);
        variableDAO.saveHospitalToVariable(var, hosp);
        variableDAO.saveFunctionToVariable(var, function1);
        variableDAO.save(var);
        }
        
        ///// CASE 2: Two functions for one variable //////// 
        
        Functions function2 = new Functions("turn 1 to 2","rule description 2");
        functionsDAO.save(function2);
        
        Functions function3 = new Functions("turn 2 to 3","rule description 3");
        functionsDAO.save(function3);
        
        Variables var2 = new Variables("variable2 ","variable description2 ","type2 ");
        variableDAO.saveVersionToVariable(var2, ver);
        variableDAO.saveHospitalToVariable(var2, hosp);
        variableDAO.saveFunctionToVariable(var2, function2);
        variableDAO.saveFunctionToVariable(var2, function3);
        variableDAO.save(var2);
        
      
            
        
    }
    
}
