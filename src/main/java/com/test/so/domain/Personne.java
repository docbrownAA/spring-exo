package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id",
//        scope = Personne.class)
public class Personne implements Serializable {

    private int id;
    private Date dateNaissance;
    private String nom;
    private String prenom;

    @JsonIgnoreProperties("personne")
    Collection<Telephone> telephones;

    @JsonIgnoreProperties("personne")
    PersonneDetail personneDetail;

    @JsonIgnoreProperties("personne")
    private Collection<PersonneAdresse> personnesAdresses = new ArrayList<PersonneAdresse>();

    public Personne() {
    }

    public Personne(int id, Date date_naissance, String nom, String prenom, Collection<Telephone> telephones, PersonneDetail personneDetail) {
        this.id = id;
        this.dateNaissance = date_naissance;
        this.nom = nom;
        this.prenom = prenom;
        this.telephones = telephones;
        this.personneDetail = personneDetail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_personne")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "personne")
    public Collection<PersonneAdresse> getPersonnesAdresses() {
        return personnesAdresses;
    }

    public void setPersonnesAdresses(Collection<PersonneAdresse> personnesAdresses) {
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
    @Column(name="date_naissance")
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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
