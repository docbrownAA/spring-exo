package com.test.so.repository;

import com.test.so.domain.Pays;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author GDUVINAGE
 */
public interface PaysRepository extends JpaRepository<Pays, Long> {
    Collection<Pays> findByNom(String nom);
}
