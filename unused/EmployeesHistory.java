/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.unused;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Duration;
import java.time.Period;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.jooq.DataType;
import org.jooq.impl.SQLDataType;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.w3c.dom.ranges.Range;


/**
 *
 * @author root
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="EmployeesHisotry")
@EntityListeners(AuditingEntityListener.class)
public class EmployeesHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String designation;
    
    @NotBlank
    private String expertise;
    
    
    @LastModifiedDate
    //@Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;



  // @Column(name = "sys_period")
  // @Convert(converter = InstantRangeConverter.class)
   //Date[] dateArray;
          // Range sys_period;
 //String sys_period;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
}
