/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.domain.Prijava;
import java.util.List;

/**
 *
 * @author Jovan Petrovic
 */
public interface PrijavaService {

    List<Prijava> getAll();

    Prijava findbyId(Long id);

    void add(Prijava prijava);

    void delete(Long id);
}
