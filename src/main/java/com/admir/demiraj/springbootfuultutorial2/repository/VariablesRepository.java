/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.repository;

import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author root
 */
public interface VariablesRepository extends JpaRepository<Variables, Long>{
    
    //public Page<Variables> findById(Long hospitalsId, Pageable pageable);
    
    public Optional<Variables> findById(Long hospital_id);
    
    public Optional<Variables> findByHospitalid(Long hospital_id);
    
}
