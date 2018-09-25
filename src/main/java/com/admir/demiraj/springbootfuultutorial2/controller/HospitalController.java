/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.controller;

import com.admir.demiraj.springbootfuultutorial2.dao.HospitalDAO;
import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    
    @Autowired
    private HospitalDAO hospitalDAO;
    
      //get all hospitals
    @GetMapping("/hosp")
    public List<Hospitals> getAllHospitals(){
        return hospitalDAO.findAll();
    }
    
     //save a hospital to database
    @PostMapping("/hosp")
    public Hospitals createHospital(@Valid @RequestBody Hospitals hosp){
        return hospitalDAO.save(hosp);
    }
}
