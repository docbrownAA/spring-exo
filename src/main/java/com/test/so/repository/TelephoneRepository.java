package com.test.so.repository;

import com.test.so.domain.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by azizunsal on 24/02/15.
 */

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {
    
}