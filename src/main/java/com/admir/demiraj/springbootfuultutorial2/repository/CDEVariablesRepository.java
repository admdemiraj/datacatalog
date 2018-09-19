/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.repository;

import com.admir.demiraj.springbootfuultutorial2.resources.CDEVariables;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author root
 */

public interface CDEVariablesRepository extends JpaRepository<CDEVariables, Long>{
    
    @Query(value = "select * from cdevariables where cdevariables.version.version_id = ?1",nativeQuery=true )
    public List<CDEVariables> findCDEVariablesByVersion(Long VersionId);
    
    
}
