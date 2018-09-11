package com.admir.demiraj.springbootfuultutorial2.repository;

import com.admir.demiraj.springbootfuultutorial2.resources.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author root
 */
public interface EmployeeRepository extends JpaRepository<Employees, Long>{
    
    
    
}
