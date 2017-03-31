/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GDUVINAGE
 */
@Entity
@Table(name = "personne_adresse")
public class PersonneAdresse implements Serializable {

    private int id;
    private Date debut;
    private Date fin;
    private boolean principale;

    @JsonIgnoreProperties("personneAdresses")
    private Personne personne;
    @JsonIgnoreProperties("personneAdresses")
    private Adresse adresse;

    public PersonneAdresse() {
    }

    public PersonneAdresse(int id, Date debut, Date fin, boolean principale) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
        this.principale = principale;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_personne_adresse")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    @Temporal(TemporalType.DATE)
    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public boolean isPrincipale() {
        return principale;
    }

    public void setPrincipale(boolean principale) {
        this.principale = principale;
    }

    @ManyToOne
    @JoinColumn(name = "id_personne")
    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @ManyToOne
    @JoinColumn(name = "id_adresse")
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

}
