/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author GDUVINAGE
 */
@Entity
@Table(name = "personne_adresse")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.adresse", joinColumns = @JoinColumn(name = "id_adresse")),
    @AssociationOverride(name = "primaryKey.personne", joinColumns = @JoinColumn(name = "id_personne"))
})
public class PersonneAdresse implements Serializable {

    private PersonneAdressePk primaryKey = new PersonneAdressePk();

    private Date debut;
    private Date fin;
    private boolean principale;

    public PersonneAdresse() {
    }

    public PersonneAdresse(Date debut, Date fin, boolean principale) {
        this.debut = debut;
        this.fin = fin;
        this.principale = principale;
    }

    @EmbeddedId
    public PersonneAdressePk getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(PersonneAdressePk primaryKey) {
        this.primaryKey = primaryKey;
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

    @Transient
    public Personne getPersonne() {
        return getPrimaryKey().getPersonne();
    }

    public void setPersonne(Personne personne) {
        getPrimaryKey().setPersonne(personne);
    }

    @Transient
    public Adresse getAdresse() {
        return getPrimaryKey().getAdresse();
    }

    public void setAdresse(Adresse adresse) {
        getPrimaryKey().setAdresse(adresse);
    }

}
