package com.test.so.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author GDUVINAGE
 */
@Entity
public class Langue extends EntiteGenerique implements Serializable {
    
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
