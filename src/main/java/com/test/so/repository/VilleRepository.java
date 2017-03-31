package com.test.so.repository;

import com.test.so.domain.Pays;
import com.test.so.domain.Ville;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gduvinage
 */
@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer>{
    Collection<Ville> findByNom(String nom);
    Collection<Ville> findByNomContaining(String like);
    Collection<Ville> findByPays(Pays pays);
    Collection<Ville> findByCodePostalContaining(String codePostal);
}
