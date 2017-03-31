package com.test.so.repository;

import com.test.so.domain.Pays;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GDUVINAGE
 */
@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {
    Collection<Pays> findByNom(String nom);
}
