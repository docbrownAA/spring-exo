package com.test.so.repository;

import com.test.so.domain.Personne;
import com.test.so.domain.PersonneDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gduvinage
 */
@Repository
public interface PersonneDetailRepository extends JpaRepository<PersonneDetail, Integer>{
    PersonneDetail findByPersonne(Personne personne);
}
