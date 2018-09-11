/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.controller;

import com.admir.demiraj.springbootfuultutorial2.dao.HospitalDAO;
import com.admir.demiraj.springbootfuultutorial2.dao.VariableDAO;
import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/hospital")
public class HospitalVariableController {
    
    @Autowired
    private VariableDAO variableDAO;
    
    @Autowired
    private HospitalDAO hospitalDAO;
    
     //get all variables by hospital id
     @GetMapping("/{hospital_id}/variables")
    public Optional<Variables> getVariableByHospitalId(@PathVariable(value="hospital_id") Long hospitalId){
        return variableDAO.getVariableByHospitalId(hospitalId);
    }
    /*
     @GetMapping("/{hospital_id}/variables")
    public Page<Variables> getVariableByHospitalId(@PathVariable(value="hospital_id") Long hospitalId, Pageable pageable){
        return variableDAO.getVariableByHospitalId(hospitalId,pageable);
    }
    
    */
   
    
    // add to specific hospital some variables
    @PostMapping("/{hospital_id}/variables")
    public void createVariable(@PathVariable (value = "hospital_id") Long hospitalId,
                                 @Valid @RequestBody Variables variable) {
        
     variable.setHospital(hospitalDAO.getHospital(hospitalId));
     variableDAO.save(variable);
    }
    
    
     //save an variable
    @PostMapping("/variables")
    public Variables createVariable(@Valid @RequestBody Variables var){
        return variableDAO.save(var);
    }
    
    
    
    
    
    
}
