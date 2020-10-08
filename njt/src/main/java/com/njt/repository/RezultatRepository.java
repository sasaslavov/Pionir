/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.repository;

import com.njt.domain.Rezultat;
import com.njt.domain.RezultatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jovan Petrovic
 */

@Repository
public interface RezultatRepository extends JpaRepository<Rezultat , RezultatId>{
    
}
