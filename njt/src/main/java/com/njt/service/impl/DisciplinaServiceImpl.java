/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.domain.Disciplina;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njt.repository.DisciplinaRepository;
import com.njt.service.DisciplinaService;

/**
 *
 * @author Jovan Petrovic
 */
@Service
public class DisciplinaServiceImpl implements DisciplinaService{

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    
    @Override
    public List<Disciplina> getAll() {
        return disciplinaRepository.findAll();
    }
     
}
