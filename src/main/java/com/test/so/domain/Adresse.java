package com.test.so.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author GDUVINAGE
 */
@Entity
public class Adresse extends EntiteGenerique implements Serializable{
    
    private  String libelle;
    
    @OneToMany(mappedBy = "adresse")
    @JsonManagedReference
    private Set<PersonneAdresse> personnes = new HashSet<PersonneAdresse>();

    public Set<PersonneAdresse> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<PersonneAdresse> personnes) {
        this.personnes = personnes;
    }
    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
}
