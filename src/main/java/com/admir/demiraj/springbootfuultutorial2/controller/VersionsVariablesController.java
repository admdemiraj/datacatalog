/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.controller;

import com.admir.demiraj.springbootfuultutorial2.dao.HospitalDAO;
import com.admir.demiraj.springbootfuultutorial2.dao.VariableDAO;
import com.admir.demiraj.springbootfuultutorial2.dao.VersionDAO;
import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import com.admir.demiraj.springbootfuultutorial2.resources.Versions;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
@RequestMapping("/hospital")
public class VersionsVariablesController {
    
    @Autowired
    private VariableDAO variableDAO;
    
    @Autowired
    private VersionDAO versionDAO;
    
   @Autowired
   private HospitalDAO hospitalDAO;
   

   
    @GetMapping("/{hospital_id}/variables/{version_id}")
    public List<Variables> getVariableByHospitalIdAndVersionId(@PathVariable(value="hospital_id") Long hospitalId,
            @PathVariable(value="version_id") Long versionId){
        return variableDAO.getVariablesByHospitalIdAndVersionId(hospitalId, versionId);
    }

    @GetMapping("/details")
    public Long getVariableDetails(){
    Long variableId = 24l;
    Variables var = variableDAO.getVariable(variableId);
    System.out.println(var.getName()+var.getDescription()+var.getType());
    System.out.println(var.getVersions());
    return var.getHospital().getId();
    
    }
    
    
    //save variables
    @GetMapping("/variables")
    public Variables saveVariable(){
        
        Variables var = new Variables("variable1","some variable","some type");
        Versions ver = new Versions("version 1");
        Hospitals hosp = new Hospitals("hospital 1");
        
        //save version
        versionDAO.saveVersion(ver);
        variableDAO.saveVersionToVariable(var, ver);
        
        //save hospital
        hospitalDAO.save(hosp);
        variableDAO.saveHospitalToVariable(var, hosp);
        
        //save variable
        System.err.println("saved variable");
        return variableDAO.save(var);
            
        
    }
    
    
    
}
