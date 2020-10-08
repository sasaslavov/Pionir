/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.domain.Plivac;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njt.repository.PlivacRepository;
import com.njt.service.PlivacService;

/**
 *
 * @author Jovan Petrovic
 */

@Service
@Transactional
public class PlivacServiceImpl implements PlivacService{

    @Autowired
    private PlivacRepository plivacRepository;
    
    @Override
    public List<Plivac> getAll() {
        return plivacRepository.findAll();
    }

    @Override
    public Plivac findbyId(Long id) {
        Optional<Plivac> optionalPlivac = plivacRepository.findById(id);
        if (optionalPlivac.isPresent()) {
            return optionalPlivac.get();
        }
        return null;
    }

    @Override
    public void add(Plivac plivac) {
        plivacRepository.save(plivac);
    }

    @Override
    public void delete(Long id) {
        plivacRepository.deleteById(id);
    }
    
}
