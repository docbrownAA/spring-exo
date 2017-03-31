package com.test.so.service;

import com.test.so.domain.PersonneDetail;
import com.test.so.domain.Personne;

/**
 *
 * @author gduvinage
 */
public interface PersonneDetailService {
    PersonneDetail findByPersonne(Personne personne);
    PersonneDetail create(PersonneDetail personneDetail);
}
