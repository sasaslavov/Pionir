/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.domain.Takmicenje;
import com.njt.repository.TakmicenjeRepository;
import com.njt.service.TakmicenjeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jovan Petrovic
 */
@Service
public class TakmicenjeServiceImpl implements TakmicenjeService{
    
    @Autowired
    private TakmicenjeRepository takmicenjeRepository;
    

    @Override
    public List<Takmicenje> getAll() {
        return takmicenjeRepository.findAll();
    }

    @Override
    public Takmicenje findbyId(Long id) {
        Optional<Takmicenje> takmicenje = takmicenjeRepository.findById(id);
        if(takmicenje.isPresent()){
            return takmicenje.get();
        }
        return null;
    }

    @Override
    public void add(Takmicenje takmicenje) {
        takmicenjeRepository.save(takmicenje);
    }

    @Override
    public void delete(Long id) {
        takmicenjeRepository.deleteById(id);
    }
    
    
}
