/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.dao;

import com.admir.demiraj.springbootfuultutorial2.repository.HospitalsRepository;
import com.admir.demiraj.springbootfuultutorial2.resources.Employees;
import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class HospitalDAO {
      
    @Autowired
    private HospitalsRepository hospitalsRepository;

    
    // save hospital in db
    public Hospitals save(Hospitals hosp){
        return hospitalsRepository.save(hosp);
    }
    
    
    //show all hospitals
    
    public List<Hospitals> findAll(){
        return hospitalsRepository.findAll();
    }
    
    //get an hospital by id
    public Hospitals getHospital(Long id){
        return hospitalsRepository.getOne(id);
    }
    
    //delete a hospital given it's id
   public void deleteEmployee(long id){
       hospitalsRepository.deleteById(id);
   }
    
    
}
