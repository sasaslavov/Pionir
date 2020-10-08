/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.domain.Takmicenje;
import java.util.List;

/**
 *
 * @author Jovan Petrovic
 */
public interface TakmicenjeService {
    
    List<Takmicenje> getAll();
    
    Takmicenje findbyId(Long id);
    
    void add (Takmicenje takmicenje);
    
    void delete (Long id);
    
}
