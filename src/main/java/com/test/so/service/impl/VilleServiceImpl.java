package com.test.so.service.impl;

import com.test.so.domain.Pays;
import com.test.so.domain.Ville;
import com.test.so.repository.VilleRepository;
import com.test.so.service.VilleService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gduvinage
 */
@Service
public class VilleServiceImpl implements VilleService {
    
    @Autowired
    VilleRepository villeRepository;

    @Override
    public Collection<Ville> findByNom(String nom) {
        return villeRepository.findByNom(nom);
    }

    @Override
    public Collection<Ville> findByNomContainig(String like) {
        return villeRepository.findByNomContaining(like);
    }

    @Override
    public Collection<Ville> findByPays(Pays pays) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Ville> findByCodePostalContaining(String codePostal) {
        return villeRepository.findByCodePostalContaining(codePostal);
    }

    @Override
    public Collection<Ville> findAll() {
        return villeRepository.findAll();
    }
    
    
}
