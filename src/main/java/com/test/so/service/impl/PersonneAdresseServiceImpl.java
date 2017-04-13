package com.test.so.service.impl;

import com.test.so.domain.PersonneAdresse;
import com.test.so.repository.PersonneAdresseRepository;
import com.test.so.service.PersonneAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gduvinage
 */
@Service
public class PersonneAdresseServiceImpl implements PersonneAdresseService{
    @Autowired
    PersonneAdresseRepository personneAdresseRepository;

    @Override
    public PersonneAdresse save(PersonneAdresse personneAdresse) {
        return personneAdresseRepository.save(personneAdresse);
    }
    
    
}
