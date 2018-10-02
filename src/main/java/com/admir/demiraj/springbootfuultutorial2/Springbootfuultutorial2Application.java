package com.admir.demiraj.springbootfuultutorial2;

import com.admir.demiraj.springbootfuultutorial2.controller.EmployeeController;
import com.admir.demiraj.springbootfuultutorial2.dao.EmployeeDAO;
import com.admir.demiraj.springbootfuultutorial2.repository.VariablesRepository;
import com.admir.demiraj.springbootfuultutorial2.resources.Employees;
import com.admir.demiraj.springbootfuultutorial2.resources.Hospitals;
import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import com.admir.demiraj.springbootfuultutorial2.resources.Versions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan(basePackageClasses = EmployeeController.class)
//@EnableJpaRepositories("com.admir.demiraj.dao")
public class Springbootfuultutorial2Application {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(Springbootfuultutorial2Application.class, args);
        //save a hospital

 /**
  *
  *  String tstzrange = "'2013-10-01 10:00-07','2013-10-03 05:15-07'";
  *
  *
  *         Date date1,date2 = new Date();
  *
  * 	        SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-M-dd hh:mm");
  *
  * 	        String strdate1 = "2013-04-02 11:35";
  *                 String strdate2 = "2014-05-09 12:00";
  *
  *                 date1 = dateformat2.parse(strdate1);
  *                 date2 = dateformat2.parse(strdate2);
  *                 Date[] dateArray = new Date[2];
  *
  *
  *                 dateArray[0] = date1;
  *                 dateArray[1] = date2;
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *         System.out.println("Date1 \n"+dateformat2.format(dateArray[0])+"\n Date2\n"+dateformat2.format(dateArray[1]));
  *
  *
  * */
 


 

        
    }
}
