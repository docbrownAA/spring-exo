package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

    private Integer id;
    private String libelle;
    @JsonIgnoreProperties("adresses")
    private Ville ville;

    @JsonIgnoreProperties("adresse")
    private Collection<PersonneAdresse> personneAdresses = new ArrayList<PersonneAdresse>();

    public Adresse() {
    }

    public Adresse(String libelle, Integer id) {
        this.libelle = libelle;
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_adresse")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "adresse")
    public Collection<PersonneAdresse> getPersonneAdresses() {
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

    public void setPersonneAdresses(Collection<PersonneAdresse> personneAdresses) {
        this.personneAdresses = personneAdresses;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
