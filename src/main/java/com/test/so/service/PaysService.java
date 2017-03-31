package com.test.so.service;

import com.test.so.domain.Pays;
import java.util.Collection;

/**
 *
 * @author GDUVINAGE
 */
public interface PaysService {
    Pays findByNom(String Nom);
    Collection<Pays> findAll();
}
