/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jovan Petrovic
 */
@Entity
@Table(name = "rezultat")
public class Rezultat implements Serializable {

    @EmbeddedId
    private RezultatId id;

    @ManyToOne
    @JoinColumn(name = "takmicenjeId", insertable = false, updatable = false)
    private Takmicenje takmicenje;

    @ManyToOne
    @JoinColumn(name = "plivacId", insertable = false, updatable = false)
    private Plivac plivac;

    private double prviRezultat;
    private double drugiRezultat;
    private int pozicija;

    public Rezultat() {
    }

    public RezultatId getId() {
        return id;
    }

    public void setId(RezultatId id) {
        this.id = id;
    }

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }

    public Plivac getPlivac() {
        return plivac;
    }

    public void setPlivac(Plivac plivac) {
        this.plivac = plivac;
    }

    public double getPrviRezultat() {
        return prviRezultat;
    }

    public void setPrviRezultat(double prviRezultat) {
        this.prviRezultat = prviRezultat;
    }

    public double getDrugiRezultat() {
        return drugiRezultat;
    }

    public void setDrugiRezultat(double drugiRezultat) {
        this.drugiRezultat = drugiRezultat;
    }

    public int getPozicija() {
        return pozicija;
    }

    public void setPozicija(int pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.takmicenje);
        hash = 29 * hash + Objects.hashCode(this.plivac);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.prviRezultat) ^ (Double.doubleToLongBits(this.prviRezultat) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.drugiRezultat) ^ (Double.doubleToLongBits(this.drugiRezultat) >>> 32));
        hash = 29 * hash + this.pozicija;
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
        final Rezultat other = (Rezultat) obj;
        if (Double.doubleToLongBits(this.prviRezultat) != Double.doubleToLongBits(other.prviRezultat)) {
            return false;
        }
        if (Double.doubleToLongBits(this.drugiRezultat) != Double.doubleToLongBits(other.drugiRezultat)) {
            return false;
        }
        if (this.pozicija != other.pozicija) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.takmicenje, other.takmicenje)) {
            return false;
        }
        if (!Objects.equals(this.plivac, other.plivac)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rezultat{" + "id=" + id + ", takmicenje=" + takmicenje + ", plivac=" + plivac + ", prviRezultat=" + prviRezultat + ", drugiRezultat=" + drugiRezultat + ", pozicija=" + pozicija + '}';
    }

    

}
