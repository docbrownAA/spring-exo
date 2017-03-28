package com.test.so.domain;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author GDUVINAGE
 */
@Entity
public class Pays extends EntiteGenerique implements Serializable {
    
    private String nom;
    private Integer popultation;
    private String monnaie;
    private String continent;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPopultation() {
        return popultation;
    }

    public void setPopultation(Integer popultation) {
        this.popultation = popultation;
    }

    public String getMonnaie() {
        return monnaie;
    }

    public void setMonnaie(String monnaie) {
        this.monnaie = monnaie;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    
}
