package com.test.so.service.impl;

import com.test.so.domain.PersonneDetail;
import com.test.so.domain.Personne;
import com.test.so.repository.PersonneDetailRepository;
import com.test.so.service.PersonneDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gduvinage
 */
@Service
public class PersonneDetailServiceImpl implements PersonneDetailService {

    @Autowired
    PersonneDetailRepository personneDetailRepository;

    @Override
    public PersonneDetail findByPersonne(Personne personne) {
        return personneDetailRepository.findByPersonne(personne);
    }

    @Override
    public PersonneDetail create(PersonneDetail personneDetail) {
        return personneDetailRepository.save(personneDetail);
    }
    
    @Override
    public PersonneDetail save(PersonneDetail personneDetail) {
        return personneDetailRepository.save(personneDetail);
    }

    @Override
    public void delete(Integer personneDetailId) {
       personneDetailRepository.delete(personneDetailId);
    }
    
    
    

}
