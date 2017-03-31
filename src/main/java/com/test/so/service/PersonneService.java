/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.service;

import com.test.so.domain.Personne;
import java.util.Collection;

/**
 *
 * @author gduvinage
 */
public interface PersonneService {
    Personne findById(Integer id);
    Collection<Personne> findAll();
    Personne findByNomAndPrenom(String nom, String prenom);
    Personne create(Personne personne);
}
