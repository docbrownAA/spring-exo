package com.test.so.service.impl;

import com.test.so.domain.Personne;
import com.test.so.repository.PersonneRepository;
import com.test.so.service.PersonneService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gduvinage
 */
@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    @Override
    public Personne findById(Integer id) {
        return personneRepository.findOne(id);
    }

    @Override
    public Personne findByNomAndPrenom(String nom, String prenom) {
        return personneRepository.findByNomAndPrenom(nom, prenom);
    }

    @Override
    public Collection<Personne> findAll() {
        return personneRepository.findAll();

    }

    @Override
    public Personne create(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public void delete(Personne personne) {
        personneRepository.delete(personne);
    }

    @Override
    public Personne update(Personne personne) {
        return personneRepository.save(personne);
    }
    
    

}
