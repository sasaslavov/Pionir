/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jovan Petrovic
 */

@Entity
@Table(name = "prijava")
public class Prijava implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prijavaId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date datumPrijave;
    @ManyToOne
    @JoinColumn(name = "plivacId", insertable = true, updatable = true)
    private Plivac plivac;
    @ManyToOne
    @JoinColumn(name = "takmicenjeId", insertable = true, updatable = true)
    private Takmicenje takmicenje;

    public Prijava() {
    }

    @Override
    public String toString() {
        return "Prijava{" + "prijavaId=" + prijavaId + ", datumPrijave=" + datumPrijave + ", plivac=" + plivac + ", takmicenje=" + takmicenje + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.prijavaId);
        hash = 67 * hash + Objects.hashCode(this.datumPrijave);
        hash = 67 * hash + Objects.hashCode(this.plivac);
        hash = 67 * hash + Objects.hashCode(this.takmicenje);
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
        final Prijava other = (Prijava) obj;
        if (!Objects.equals(this.prijavaId, other.prijavaId)) {
            return false;
        }
        if (!Objects.equals(this.datumPrijave, other.datumPrijave)) {
            return false;
        }
        if (!Objects.equals(this.plivac, other.plivac)) {
            return false;
        }
        if (!Objects.equals(this.takmicenje, other.takmicenje)) {
            return false;
        }
        return true;
    }

    public Long getPrijavaId() {
        return prijavaId;
    }

    public void setPrijavaId(Long prijavaId) {
        this.prijavaId = prijavaId;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public Plivac getPlivac() {
        return plivac;
    }

    public void setPlivac(Plivac plivac) {
        this.plivac = plivac;
    }

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }

}
