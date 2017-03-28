/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

    @EmbeddedId
    PersonneAdresseId pk;

    @Temporal(TemporalType.DATE)
    private Date debut;
    @Temporal(TemporalType.DATE)
    private Date fin;

    private boolean principale;

    @JoinColumn(name = "id_adresse", referencedColumnName = "id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Adresse adresse;
    @JoinColumn(name = "id_personne", referencedColumnName = "id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Personne personne;

    public PersonneAdresse() {
    }

    public PersonneAdresse(PersonneAdresseId personneAdresseId) {
        this.pk = personneAdresseId;
    }

    public PersonneAdresse(int idPersonne, int idAdresse) {
        this.pk = new PersonneAdresseId(idPersonne, idAdresse);
    }

    public PersonneAdresseId getPk() {
        return pk;
    }

    public void setPk(PersonneAdresseId pk) {
        this.pk = pk;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

}
