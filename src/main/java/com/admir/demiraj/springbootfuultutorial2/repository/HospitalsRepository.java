/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.repository;

import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author root
 */
public interface HospitalsRepository extends JpaRepository<Hospitals, Long>{
    
}




