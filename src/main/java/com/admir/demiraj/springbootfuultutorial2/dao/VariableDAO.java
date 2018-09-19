/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.dao;

import com.admir.demiraj.springbootfuultutorial2.repository.VariablesRepository;
import com.admir.demiraj.springbootfuultutorial2.resources.Functions;
import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import com.admir.demiraj.springbootfuultutorial2.resources.Versions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author root
 */
@Service
public class VariableDAO {
    
    @Autowired
    private VariablesRepository variablesRepository;
    
    @Autowired
    private VersionDAO versionDao;
    
    


    public void saveVersionToVariable(Variables var, Versions ver){
        var.setVersions(ver);
    
    }
    
    public void saveFunctionToVariable(Variables var, Functions function){
    var.setFunction(function);
    }
    public void saveHospitalToVariable(Variables var, Hospitals hosp){
        var.setHospital(hosp);
   
    }
    /**
     Method that given a variableId returns all the possible mappings that the 
     * variable may have in the creation of CDEVariables
     */
    public List<Variables> variablesToCdeVariables(Long variableId){
        return variablesRepository.variablesToCdeVariables(variableId);
    
    }
    
    
    //find variable by hospital id
    
   public List<Variables> getVariableByHospitalId(Long HospitalId){
        return variablesRepository.findByHospitalid(HospitalId);
   } 
 
   public List<Variables> getVariablesByHospitalIdAndVersionId(Long hospitalId, Long versionId){
       List<Variables> allVariables = variablesRepository.findByHospitalid(hospitalId);
       //test
       //List<Variables> allVariables = variablesRepository.findByVariableName("var4");
       List<Variables> variablesByVersion = new ArrayList();
   
       for(Variables v : allVariables){
           if(v.getVersions().contains(versionDao.getVersionById(versionId))){
           variablesByVersion.add(v);
           }
       }
       return variablesByVersion;
       
   }
   
   public Long getHospitalId(Long variableId){
       return variablesRepository.findHospitalIdByVariableId(variableId);
   }
   
    // save variable in db
    public Variables save(Variables var){
        return variablesRepository.save(var);
    }
    
    
    //show all variables
    
    public List<Variables> findAll(){
        return variablesRepository.findAll();
    }
    
    //get an variable by id
    public Variables getVariable(Long id){
        return variablesRepository.getOne(id);
    }
    
    //delete a variable given it's id
   public void deleteVariable(long id){
       variablesRepository.deleteById(id);
   }
    
}
