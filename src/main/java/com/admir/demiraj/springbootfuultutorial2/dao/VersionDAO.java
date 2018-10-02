/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.dao;

import com.admir.demiraj.springbootfuultutorial2.repository.VersionsRepository;
import com.admir.demiraj.springbootfuultutorial2.resources.Versions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author root
 */
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class VersionDAO {
    
    @Autowired
    private VersionsRepository versionsRepository;
    
    public Versions saveVersion(Versions ver){
        return versionsRepository.save(ver);
    }
    
    public Versions getVersionById(Long versionId){
        return versionsRepository.getOne(versionId);
    }
    
    
}
