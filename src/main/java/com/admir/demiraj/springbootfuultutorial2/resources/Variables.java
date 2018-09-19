/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author root
 */
@Entity
@Table(name="Variables")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class Variables implements Serializable{

    public Variables(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Variables() {
    }
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long variable_id;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
    
    @NotBlank
    private String type;

    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hospital_id", nullable = false) 
    @JsonBackReference
    private Hospitals hospital;
    
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,cascade =  {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "variables_functions",joinColumns = { @JoinColumn(name = "variable_id") },inverseJoinColumns = { @JoinColumn(name = "function_id") })
    private Set<Functions> function = new HashSet<>();
    
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,cascade =  {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "variables_versions",joinColumns = { @JoinColumn(name = "variable_id") },inverseJoinColumns = { @JoinColumn(name = "version_id") })
    private Set<Versions> versions = new HashSet<>();

    public Set<Versions> getVersions() {
        return versions;
    }

    public void setVersions(Versions version) {
        this.versions.add(version);
    }

    public Long getVariable_id() {
        return variable_id;
    }

    public void setVariable_id(Long variable_id) {
        this.variable_id = variable_id;
    }
    
    
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Hospitals getHospital() {
        return hospital;
    }
 
    public void setHospital(Hospitals hospital) {
        this.hospital = hospital;
    }

    public Set<Functions> getFunction() {
        return function;
    }

    public void setFunction(Functions function) {
        this.function.add(function);
    }

   
    
    
    
}
