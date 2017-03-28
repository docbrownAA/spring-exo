package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gduvinage
 */
@Entity
@Table(name = "personne")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Personne extends EntiteGenerique implements Serializable {

    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "personne", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    Collection<Telephone> telephones;

    @OneToOne(mappedBy = "personne")
    @JsonManagedReference
    PersonneDetail personneDetail;

    public Collection<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(Collection<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public PersonneDetail getPersonneDetail() {
        return personneDetail;
    }

    public void setPersonneDetail(PersonneDetail personneDetail) {
        this.personneDetail = personneDetail;
    }

}
