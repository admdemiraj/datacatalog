/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.controller;

/**
 *
 * @author root
 */
import com.admir.demiraj.springbootfuultutorial2.dao.CDEVariableDAO;
import com.admir.demiraj.springbootfuultutorial2.dao.VersionDAO;
import com.admir.demiraj.springbootfuultutorial2.resources.CDEVariables;
import com.admir.demiraj.springbootfuultutorial2.resources.Versions;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author root
 */
@RestController
@RequestMapping("/CDE")
public class CDEVariableController {
    
    @Autowired
    private CDEVariableDAO cdeVariableDAO;
    
    @Autowired
    private VersionDAO versionDAO;
    
    
    //get all cde-variables by version
    @GetMapping("/all_by_version/{version_id}")
    public List<CDEVariables> getAllCDEVariablesByVersion(@PathVariable(value="version_id") Long version_id){
        return cdeVariableDAO.findCDEVariablesByVersionId(version_id);
    }
     //save a cde-variable
   
    //save variables
    @GetMapping("/save")
    public CDEVariables saveVariable(){
        
        CDEVariables cdevar = new CDEVariables("cd1", "file1", null, null, null, null, null, null);
        Versions ver = new Versions("version 1");
       
        
        //save version
        versionDAO.saveVersion(ver);
        cdeVariableDAO.saveVersionToCDEVariable(cdevar, ver);
        

        return cdeVariableDAO.save(cdevar);
    }
    
    
    
    //get all cde-variables
    @GetMapping("/all")
    public List<CDEVariables> getAllCDEVariables(){
        return cdeVariableDAO.findAll();
    }
    
    
    
    
}
