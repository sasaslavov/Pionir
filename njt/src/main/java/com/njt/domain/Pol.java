/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.domain;

import java.io.Serializable;

/**
 *
 * @author Jovan Petrovic
 */
public class Pol implements Serializable{
    private String naziv;

    public Pol() {
    }

    public Pol(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
