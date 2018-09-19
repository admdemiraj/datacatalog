/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.resources;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author root
 */
@Entity
@Table(name="CDEVariables")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class CDEVariables{

    public CDEVariables(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public CDEVariables() {
    }
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cdevariable_id;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
    
    @NotBlank
    private String type;
    
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,cascade =  {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "cdevariables_versions",joinColumns = { @JoinColumn(name = "cdevariable_id") },inverseJoinColumns = { @JoinColumn(name = "version_id") })
    private Set<Versions> versions = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "function_id", nullable = false)
    private Functions function;

    public Functions getFunction() {
        return function;
    }

    public void setFunction(Functions function) {
        this.function = function;
    }
    
    
    public Long getCdevariable_id() {
        return cdevariable_id;
    }

    public void setCdevariable_id(Long cdevariable_id) {
        this.cdevariable_id = cdevariable_id;
    }

    public Set<Versions> getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions.add(versions);
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
    
}
