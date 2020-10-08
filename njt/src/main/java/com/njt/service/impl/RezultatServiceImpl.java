/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.domain.Rezultat;
import com.njt.domain.RezultatId;
import com.njt.repository.RezultatRepository;
import com.njt.service.RezultatService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jovan Petrovic
 */

@Service
public class RezultatServiceImpl implements RezultatService{

    @Autowired
    private RezultatRepository  rezultatRepository;
    
    @Override
    public List<Rezultat> getAll() {
        return rezultatRepository.findAll();
    }

    @Override
    public Rezultat findbyId(RezultatId id) {
        Optional<Rezultat> rezultat = rezultatRepository.findById(id);
        if (rezultat.isPresent()){
            return rezultat.get();
        }
        return null;
    }

    @Override
    public void add(Rezultat rezultat) {
        rezultatRepository.save(rezultat);
    }

    @Override
    public void delete(RezultatId id) {
        rezultatRepository.deleteById(id);
    }
    
}
