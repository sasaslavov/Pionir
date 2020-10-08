/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jovan Petrovic
 */

@Embeddable
public class RezultatId implements Serializable{
    
    @Column (name = "plivacId")
    private Long plivacId;
    @Column (name = "takmicenjeId")
    private Long takmicenjeId;

    public RezultatId() {
    }

    public RezultatId(Long plivacId, Long takmicenjeId) {
        this.plivacId = plivacId;
        this.takmicenjeId = takmicenjeId;
    }

    public Long getPlivacId() {
        return plivacId;
    }

    public void setPlivacId(Long plivacId) {
        this.plivacId = plivacId;
    }

    public Long getTakmicenjeId() {
        return takmicenjeId;
    }

    public void setTakmicenjeId(Long takmicenjeId) {
        this.takmicenjeId = takmicenjeId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.plivacId);
        hash = 97 * hash + Objects.hashCode(this.takmicenjeId);
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
        final RezultatId other = (RezultatId) obj;
        if (!Objects.equals(this.plivacId, other.plivacId)) {
            return false;
        }
        if (!Objects.equals(this.takmicenjeId, other.takmicenjeId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RezultatID{" + "plivacId=" + plivacId + ", takmicenjeId=" + takmicenjeId + '}';
    }

}
