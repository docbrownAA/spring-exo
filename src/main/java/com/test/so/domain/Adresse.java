package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author GDUVINAGE
 */
@Entity
public class Adresse implements Serializable {

    private int id;
    private String libelle;
    @JsonIgnoreProperties("adresses")
    private Ville ville;

    @JsonIgnoreProperties("adresse")
    private Set<PersonneAdresse> personneAdresses = new HashSet<PersonneAdresse>();

    public Adresse() {
    }

    public Adresse(String libelle, int id) {
        this.libelle = libelle;
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_adresse")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "adresse")
    public Set<PersonneAdresse> getPersonneAdresses() {
        return personneAdresses;
    }

    @ManyToOne
    @JoinColumn(name = "id_ville")
    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public void setPersonneAdresses(Set<PersonneAdresse> personneAdresses) {
        this.personneAdresses = personneAdresses;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
