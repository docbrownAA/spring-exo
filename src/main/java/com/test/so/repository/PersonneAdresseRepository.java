package com.test.so.repository;

import com.test.so.domain.PersonneAdresse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gduvinage
 */
public interface PersonneAdresseRepository extends JpaRepository<PersonneAdresse, Integer>{
    PersonneAdresse findById(int id);
    PersonneAdresse findByPersonneIdAndAdresseId(int personneId, int adresseId);
    
    
}
