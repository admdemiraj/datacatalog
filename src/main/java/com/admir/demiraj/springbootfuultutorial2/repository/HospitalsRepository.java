/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.repository;

import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author root
 */
@CrossOrigin(origins = "http://localhost:4200")
public interface HospitalsRepository extends JpaRepository<Hospitals, Long>{
    
}




