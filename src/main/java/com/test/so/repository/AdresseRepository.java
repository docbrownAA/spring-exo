/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.repository;

import com.test.so.domain.Adresse;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gduvinage
 */
@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer>{
    Collection<Adresse> findByLibelleContaining(String libelle);
    Collection<Adresse> findByVilleNom(String nom);
}
