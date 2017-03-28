/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author GDUVINAGE
 */
@Embeddable
public class PersonneAdresseId implements Serializable {
    /**
      *
      */
     private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "id_personne")
    private int idPersonne;
    @Basic(optional = false)
    @Column(name = "id_adresse")
    private int idAdresse;
    
    public PersonneAdresseId(){
        
    }
    
    public PersonneAdresseId(int idPersonne, int idAdresse){
        this.idAdresse = idAdresse;
        this.idPersonne = idPersonne;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }
    
    
    
}
