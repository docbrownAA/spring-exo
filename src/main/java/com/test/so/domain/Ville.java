/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author gduvinage
 */
@Entity
public class Ville implements Serializable {
    
    
    private int id;
    private boolean capital;
    private String codePostal;
    private String nom;
    
    @JsonIgnoreProperties("ville")
    private Set<Adresse> adresses = new HashSet<Adresse>();
    
    @JsonIgnoreProperties("villes")
    private Pays pays;

    public Ville() {
    }

    public Ville(int id, boolean capital, String codePostal, String nom, Pays pays) {
        this.id = id;
        this.capital = capital;
        this.codePostal = codePostal;
        this.nom = nom;
        this.pays = pays;
    }
    
    

    @Id
    @Column(name="id_ville")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @ManyToOne
    @JoinColumn(name = "id_pays")
    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @OneToMany(mappedBy = "ville")
    public Set<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<Adresse> adresses) {
        this.adresses = adresses;
    }
    
    
    
    
    
}
