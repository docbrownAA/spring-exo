package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Personne implements Serializable {

    private int id;
    private Date date_naissance;
    private String nom;
    private String prenom;

    @JsonIgnoreProperties("personne")
    Collection<Telephone> telephones;

    @JsonIgnoreProperties("personne")
    PersonneDetail personneDetail;

    @JsonIgnoreProperties("personne")
    private Set<PersonneAdresse> personnesAdresses = new HashSet<PersonneAdresse>();

    public Personne() {
    }

    public Personne(int id, Date date_naissance, String nom, String prenom, Collection<Telephone> telephones, PersonneDetail personneDetail) {
        this.id = id;
        this.date_naissance = date_naissance;
        this.nom = nom;
        this.prenom = prenom;
        this.telephones = telephones;
        this.personneDetail = personneDetail;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_personne")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "personne")
    public Set<PersonneAdresse> getPersonnesAdresses() {
        return personnesAdresses;
    }

    public void setPersonnesAdresses(Set<PersonneAdresse> personnesAdresses) {
        this.personnesAdresses = personnesAdresses;
    }

    @OneToMany(mappedBy = "personne", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    public Collection<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(Collection<Telephone> telephones) {
        this.telephones = telephones;
    }

    @Temporal(TemporalType.DATE)
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

    @OneToOne(mappedBy = "personne")
    public PersonneDetail getPersonneDetail() {
        return personneDetail;
    }

    public void setPersonneDetail(PersonneDetail personneDetail) {
        this.personneDetail = personneDetail;
    }

}
