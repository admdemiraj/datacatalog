/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.repository;

import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import com.admir.demiraj.springbootfuultutorial2.resources.Versions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author root
 */
@CrossOrigin(origins = "http://localhost:4200")
public interface HospitalsRepository extends JpaRepository<Hospitals, Long>{

    @Query(value = "select hospital_id from hospitals", nativeQuery=true)
    public List<BigInteger> getAllHospitalIds();

    @Query(value = "select name from hospitals where hospitals.hospital_id = ?1", nativeQuery=true)
    public String getHospitalNameById(BigInteger hospId);


}




