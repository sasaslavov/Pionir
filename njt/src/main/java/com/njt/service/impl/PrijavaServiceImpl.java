/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.domain.Prijava;
import com.njt.repository.PrijavaRepository;
import com.njt.service.PrijavaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jovan Petrovic
 */
@Service
public class PrijavaServiceImpl implements PrijavaService{
    
    @Autowired
    private PrijavaRepository prijavaRepository;

    @Override
    public List<Prijava> getAll() {
        return prijavaRepository.findAll();
    }

    @Override
    public Prijava findbyId(Long id) {
        Optional<Prijava> prijava = prijavaRepository.findById(id);
        if(prijava.isPresent()){
            return prijava.get();
        }
        return null;
    }

    @Override
    public void add(Prijava prijava) {
        prijavaRepository.save(prijava);
    }

    @Override
    public void delete(Long id) {
        prijavaRepository.deleteById(id);
    }
    
}
