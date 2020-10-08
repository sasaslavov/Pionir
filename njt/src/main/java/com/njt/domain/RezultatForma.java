/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jovan Petrovic
 */
public class RezultatForma implements Serializable{
    private List<Rezultat> rezultati;

    public List<Rezultat> getRezultati() {
        return rezultati;
    }

    public void setRezultati(List<Rezultat> rezultati) {
        this.rezultati = rezultati;
    }
    
    
    
}
