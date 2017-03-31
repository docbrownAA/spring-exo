package com.test.so.service;

import com.test.so.domain.Adresse;
import com.test.so.domain.Ville;
import java.util.Collection;

/**
 *
 * @author gduvinage
 */
public interface AdresseService {
    Collection<Adresse> findByLibelleContaining(String libelle);
    Collection<Adresse> findAll();
    Collection<Adresse> findByVilleNom(String nom);
}
