package com.test.so.service.impl;

import com.test.so.domain.Adresse;
import com.test.so.domain.Ville;
import com.test.so.repository.AdresseRepository;
import com.test.so.service.AdresseService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gduvinage
 */
@Service
public class AdresseServiceImpl implements AdresseService {
    
    @Autowired
    AdresseRepository adresseRepository;
    
    @Override
    public Collection<Adresse> findByLibelleContaining(String libelle) {
        return adresseRepository.findByLibelleContaining(libelle);
    }
    
    @Override
    public Collection<Adresse> findAll(){
        return adresseRepository.findAll();
    }
    
    @Override
    public Collection<Adresse> findByVilleNom(String nom){
        return adresseRepository.findByVilleNom(nom);
    }

    @Override
    public Adresse save(Adresse adresse) {
       return adresseRepository.save(adresse);
    }
    
    
    
}
