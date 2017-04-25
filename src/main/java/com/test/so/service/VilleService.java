/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.service;

import com.test.so.domain.Pays;
import com.test.so.domain.Ville;
import java.util.Collection;

/**
 *
 * @author gduvinage
 */
public interface VilleService {
    Collection<Ville> findByNom(String nom);
    Collection<Ville> findByNomContainig(String like);
    Collection<Ville> findByPays(Pays pays);
    Collection<Ville> findByCodePostalContaining(String codePostal);
    Collection<Ville> findAll();
    Ville findById(Integer id);
}
