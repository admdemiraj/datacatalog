package com.admir.demiraj.springbootfuultutorial2;

import com.admir.demiraj.springbootfuultutorial2.controller.EmployeeController;
import com.admir.demiraj.springbootfuultutorial2.dao.EmployeeDAO;
import com.admir.demiraj.springbootfuultutorial2.resources.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan(basePackageClasses = EmployeeController.class)
//@EnableJpaRepositories("com.admir.demiraj.dao")
public class Springbootfuultutorial2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootfuultutorial2Application.class, args);
                
                      
                
	}
}
