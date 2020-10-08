/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.domain.Rezultat;
import com.njt.domain.RezultatId;
import java.util.List;

/**
 *
 * @author Jovan Petrovic
 */
public interface RezultatService {
    
    List<Rezultat> getAll();
    
    Rezultat findbyId(RezultatId id);
    
    void add(Rezultat rezultat);
    
    void delete(RezultatId id);
            
}
