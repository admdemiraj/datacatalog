/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.repository;


import com.admir.demiraj.springbootfuultutorial2.resources.Variables;
import com.admir.demiraj.springbootfuultutorial2.resources.Versions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author root
 */
@CrossOrigin(origins = "http://localhost:4200")
public interface VersionsRepository extends JpaRepository<Versions, Long>{


    @Query(value = "SELECT * FROM versions ver "
            + "INNER JOIN variables_versions vv ON ver.version_id = vv.version_id "
            + "INNER JOIN variables var ON var.variable_id = vv.variable_id "
            + "WHERE vv.variable_id = ?1",nativeQuery=true )
    public List<Versions> getAllVersionByVariableId(Long variableId);


    @Query(value = "SELECT ver.version_id FROM versions ver "
            + "INNER JOIN variables_versions vv ON ver.version_id = vv.version_id "
            + "INNER JOIN variables var ON var.variable_id = vv.variable_id "
            + "WHERE var.hospital_id=?1 "
            + "GROUP BY ver.version_id "
            + "ORDER BY ver.version_id",nativeQuery=true )
    public List<BigInteger> getAllVersionByHospitalId(BigInteger hospitalId);

    @Query(value = "SELECT * FROM versions ver WHERE ver.version_id=?1 ",nativeQuery=true )
    public Versions getVersionById(BigInteger versionId);
}
