/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author GDUVINAGE
 */
@Embeddable
public class PersonneAdressePk implements Serializable {
    private static final long serialVersionUID = 1L;

    private Adresse adresse;
    private Personne personne;

    @ManyToOne(cascade = CascadeType.ALL)
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.adresse != null ? this.adresse.hashCode() : 0);
        hash = 53 * hash + (this.personne != null ? this.personne.hashCode() : 0);
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
        final PersonneAdressePk other = (PersonneAdressePk) obj;
        if (this.adresse != other.adresse && (this.adresse == null || !this.adresse.equals(other.adresse))) {
            return false;
        }
        if (this.personne != other.personne && (this.personne == null || !this.personne.equals(other.personne))) {
            return false;
        }
        return true;
    }

}
