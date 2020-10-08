/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jovan Petrovic
 */

@Entity
@Table(name = "zemlja")
public class Zemlja implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zemljaId;
    
    @NotNull
    @Size(min = 2, message = "Naziv zemlje mora imati minimum 2 znaka")
    private String naziv;
    @NotNull
    @Size(min = 2, message = "Glavni grad mora imati minimum 2 znaka")
    private String glavniGrad;

    public Zemlja() {
    }

    public Zemlja(Long zemljaId, String naziv, String glavniGrad) {
        this.zemljaId = zemljaId;
        this.naziv = naziv;
        this.glavniGrad = glavniGrad;
    }

    public Long getZemljaId() {
        return zemljaId;
    }

    public void setZemljaId(Long zemljaId) {
        this.zemljaId = zemljaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(String glavniGrad) {
        this.glavniGrad = glavniGrad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.zemljaId);
        hash = 17 * hash + Objects.hashCode(this.naziv);
        hash = 17 * hash + Objects.hashCode(this.glavniGrad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zemlja other = (Zemlja) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.glavniGrad, other.glavniGrad)) {
            return false;
        }
        if (!Objects.equals(this.zemljaId, other.zemljaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zemlja{" + "zemljaId=" + zemljaId + ", naziv=" + naziv + ", glavniGrad=" + glavniGrad + '}';
    }

 
    
}
