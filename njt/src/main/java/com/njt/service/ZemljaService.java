/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.domain.Zemlja;
import java.util.List;

/**
 *
 * @author Jovan Petrovic
 */
public interface ZemljaService {
    
    List<Zemlja> getAll();
    
}
