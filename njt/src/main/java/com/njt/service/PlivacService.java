/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.domain.Plivac;
import java.util.List;

/**
 *
 * @author Jovan Petrovic
 */
public interface PlivacService {
    
    List<Plivac> getAll();
    
    Plivac findbyId(Long id);
    
    void add(Plivac plivac);
    
    void delete(Long id);
}
