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


@Entity
@Table(name = "takmicenje")
public class Takmicenje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long takmicenjeId;
    private String naziv;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date datumOdrzavanja;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date rokZaPrijave;

    private String tip;

    @NotNull
    private int dozvoljenBrojPrijava;

    @NotNull
    private int brojPrijava;

    @ManyToOne
    @JoinColumn(name = "disciplinaId", insertable = true, updatable = true)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "zemljaId", insertable = true, updatable = true)
    private Zemlja zemlja;

    public Takmicenje() {
    }

    public Takmicenje(Long takmicenjeId, String naziv, Date datumOdrzavanja, Date rokZaPrijave, String tip, int dozvoljenBrojPrijava, int brojPrijava, Disciplina disciplina, Zemlja zemlja) {
        this.takmicenjeId = takmicenjeId;
        this.naziv = naziv;
        this.datumOdrzavanja = datumOdrzavanja;
        this.rokZaPrijave = rokZaPrijave;
        this.tip = tip;
        this.dozvoljenBrojPrijava = dozvoljenBrojPrijava;
        this.brojPrijava = brojPrijava;
        this.disciplina = disciplina;
        this.zemlja = zemlja;
    }

    public Long getTakmicenjeId() {
        return takmicenjeId;
    }

    public void setTakmicenjeId(Long takmicenjeId) {
        this.takmicenjeId = takmicenjeId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(Date datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public Date getRokZaPrijave() {
        return rokZaPrijave;
    }

    public void setRokZaPrijave(Date rokZaPrijave) {
        this.rokZaPrijave = rokZaPrijave;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getDozvoljenBrojPrijava() {
        return dozvoljenBrojPrijava;
    }

    public void setDozvoljenBrojPrijava(int dozvoljenBrojPrijava) {
        this.dozvoljenBrojPrijava = dozvoljenBrojPrijava;
    }

    public int getBrojPrijava() {
        return brojPrijava;
    }

    public void setBrojPrijava(int brojPrijava) {
        this.brojPrijava = brojPrijava;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Zemlja getZemlja() {
        return zemlja;
    }

    public void setZemlja(Zemlja zemlja) {
        this.zemlja = zemlja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.takmicenjeId);
        hash = 23 * hash + Objects.hashCode(this.naziv);
        hash = 23 * hash + Objects.hashCode(this.datumOdrzavanja);
        hash = 23 * hash + Objects.hashCode(this.rokZaPrijave);
        hash = 23 * hash + Objects.hashCode(this.tip);
        hash = 23 * hash + this.dozvoljenBrojPrijava;
        hash = 23 * hash + this.brojPrijava;
        hash = 23 * hash + Objects.hashCode(this.disciplina);
        hash = 23 * hash + Objects.hashCode(this.zemlja);
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
        final Takmicenje other = (Takmicenje) obj;
        if (this.dozvoljenBrojPrijava != other.dozvoljenBrojPrijava) {
            return false;
        }
        if (this.brojPrijava != other.brojPrijava) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.tip, other.tip)) {
            return false;
        }
        if (!Objects.equals(this.takmicenjeId, other.takmicenjeId)) {
            return false;
        }
        if (!Objects.equals(this.datumOdrzavanja, other.datumOdrzavanja)) {
            return false;
        }
        if (!Objects.equals(this.rokZaPrijave, other.rokZaPrijave)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.zemlja, other.zemlja)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Takmicenje{" + "takmicenjeId=" + takmicenjeId + ", naziv=" + naziv + ", datumOdrzavanja=" + datumOdrzavanja + ", rokZaPrijave=" + rokZaPrijave + ", tip=" + tip + ", dozvoljenBrojPrijava=" + dozvoljenBrojPrijava + ", brojPrijava=" + brojPrijava + ", disciplina=" + disciplina + ", zemlja=" + zemlja + '}';
    }

}
