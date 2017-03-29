package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author GDUVINAGE
 */
@Entity
public class Adresse implements Serializable {

    private String libelle;
    private int id;

    @Id
    @GeneratedValue
    @Column(name = "id_adresse")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonManagedReference
    private Set<PersonneAdresse> personneAdresses = new HashSet<PersonneAdresse>();

    @OneToMany(mappedBy = "primaryKey.adresse", cascade = CascadeType.ALL)
    public Set<PersonneAdresse> getPersonneAdresses() {
        return personneAdresses;
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
