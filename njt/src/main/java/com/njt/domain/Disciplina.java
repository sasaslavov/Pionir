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

/**
 *
 * @author Jovan Petrovic
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  disciplinaId;
   
    private String imeDiscipline;
    private String duzina;

    public Disciplina() {
    }

    public Disciplina(Long disciplinaId, String imeDiscipline, String duzina) {
        this.disciplinaId = disciplinaId;
        this.imeDiscipline = imeDiscipline;
        this.duzina = duzina;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getImeDiscipline() {
        return imeDiscipline;
    }

    public void setImeDiscipline(String imeDiscipline) {
        this.imeDiscipline = imeDiscipline;
    }

    public String getDuzina() {
        return duzina;
    }

    public void setDuzina(String duzina) {
        this.duzina = duzina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.disciplinaId);
        hash = 19 * hash + Objects.hashCode(this.imeDiscipline);
        hash = 19 * hash + Objects.hashCode(this.duzina);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.imeDiscipline, other.imeDiscipline)) {
            return false;
        }
        if (!Objects.equals(this.duzina, other.duzina)) {
            return false;
        }
        if (!Objects.equals(this.disciplinaId, other.disciplinaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "disciplinaId=" + disciplinaId + ", imeDiscipline=" + imeDiscipline + ", duzina=" + duzina + '}';
    }

    
}
