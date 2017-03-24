/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.so.repository;

import com.test.so.domain.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gduvinage
 */
@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    Personne findByNomAndPrenom(String nom, String prenom);
}
