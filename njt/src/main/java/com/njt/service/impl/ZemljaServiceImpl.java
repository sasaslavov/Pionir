/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.domain.Zemlja;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njt.repository.ZemljaRepository;
import com.njt.service.ZemljaService;

/**
 *
 * @author Jovan Petrovic
 */

@Service
public class ZemljaServiceImpl implements ZemljaService{

    @Autowired
    private ZemljaRepository zemljaRepository;
    
    @Override
    public List<Zemlja> getAll() {
        return zemljaRepository.findAll();
    }
    
    
}
