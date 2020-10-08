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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jovan Petrovic
 */
@Entity
@Table(name = "plivac")
public class Plivac implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plivacId;
    @NotNull
    @Size(min = 1, message = "Ime mora da ima vise od jednog karaktera")
    private String imePlivaca;
    @NotNull
    @Size(min = 1, message = "Prezime mora da ima vise od jednog karaktera")
    private String prezimePlivaca;
    @NotNull
    @Temporal (TemporalType.DATE)
    private Date datumRodjenja;
    @NotNull
    @Size(min = 3, message = "Licenca ima minimum 3 karaktera")
    private String brojLicence;
    @NotNull
    private String status;
    @ManyToOne
    @JoinColumn(name = "zemljaId", insertable = true, updatable = true)
    private Zemlja zemlja;
    @NotNull
    @Size(min = 1, message = "Pol ima minimum 1 karaktera")
    private String pol;

    public Plivac() {
    }

    public Plivac(Long plivacId, String imePlivaca, String prezimePlivaca, Date datumRodjenja, String brojLicence, String status, Zemlja zemlja, String pol) {
        this.plivacId = plivacId;
        this.imePlivaca = imePlivaca;
        this.prezimePlivaca = prezimePlivaca;
        this.datumRodjenja = datumRodjenja;
        this.brojLicence = brojLicence;
        this.status = status;
        this.zemlja = zemlja;
        this.pol = pol;
    }

    public Long getPlivacId() {
        return plivacId;
    }

    public void setPlivacId(Long plivacId) {
        this.plivacId = plivacId;
    }

    public String getImePlivaca() {
        return imePlivaca;
    }

    public void setImePlivaca(String imePlivaca) {
        this.imePlivaca = imePlivaca;
    }

    public String getPrezimePlivaca() {
        return prezimePlivaca;
    }

    public void setPrezimePlivaca(String prezimePlivaca) {
        this.prezimePlivaca = prezimePlivaca;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(String brojLicence) {
        this.brojLicence = brojLicence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Zemlja getZemlja() {
        return zemlja;
    }

    public void setZemlja(Zemlja zemlja) {
        this.zemlja = zemlja;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.plivacId);
        hash = 59 * hash + Objects.hashCode(this.imePlivaca);
        hash = 59 * hash + Objects.hashCode(this.prezimePlivaca);
        hash = 59 * hash + Objects.hashCode(this.datumRodjenja);
        hash = 59 * hash + Objects.hashCode(this.brojLicence);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.zemlja);
        hash = 59 * hash + Objects.hashCode(this.pol);
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
        final Plivac other = (Plivac) obj;
        if (!Objects.equals(this.imePlivaca, other.imePlivaca)) {
            return false;
        }
        if (!Objects.equals(this.prezimePlivaca, other.prezimePlivaca)) {
            return false;
        }
        if (!Objects.equals(this.brojLicence, other.brojLicence)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.pol, other.pol)) {
            return false;
        }
        if (!Objects.equals(this.plivacId, other.plivacId)) {
            return false;
        }
        if (!Objects.equals(this.datumRodjenja, other.datumRodjenja)) {
            return false;
        }
        if (!Objects.equals(this.zemlja, other.zemlja)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plivac{" + "plivacId=" + plivacId + ", imePlivaca=" + imePlivaca + ", prezimePlivaca=" + prezimePlivaca + ", datumRodjenja=" + datumRodjenja + ", brojLicence=" + brojLicence + ", status=" + status + ", zemlja=" + zemlja + ", pol=" + pol + '}';
    }

}
