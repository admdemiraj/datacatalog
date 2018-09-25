/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.dao;

import com.admir.demiraj.springbootfuultutorial2.repository.FunctionsRepository;
import com.admir.demiraj.springbootfuultutorial2.resources.Functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class FunctionsDAO {
    
    @Autowired
    FunctionsRepository functionsRepository;
    
    
     // save function
    public Functions save(Functions function){
        return functionsRepository.save(function);
    }
    
    
    
}
