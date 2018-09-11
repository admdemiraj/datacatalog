/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.dao;

import com.admir.demiraj.springbootfuultutorial2.repository.HospitalsRepository;
import com.admir.demiraj.springbootfuultutorial2.repository.VariablesRepository;
import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.w3c.dom.Comment;

/**
 *
 * @author root
 */
@Service
public class VariableDAO {
    
    @Autowired
    private VariablesRepository variablesRepository;

    
    //find variable by hospital id
    
   public Optional<Variables> getVariableByHospitalId(Long HospitalId){
        return variablesRepository.findByHospitalid(HospitalId);
   } 
   /*
   public Page<Variables> getVariableByHospitalId(Long hospitalId,Pageable pageable){
        return variablesRepository.findById(hospitalId,pageable);
    }
  
   */
   
    // save variable in db
    public Variables save(Variables var){
        return variablesRepository.save(var);
    }
    
    
    //show all variables
    
    public List<Variables> findAll(){
        return variablesRepository.findAll();
    }
    
    //get an variable by id
    public Variables getHospital(Long id){
        return variablesRepository.getOne(id);
    }
    
    //delete a variable given it's id
   public void deleteEmployee(long id){
       variablesRepository.deleteById(id);
   }
    
}
