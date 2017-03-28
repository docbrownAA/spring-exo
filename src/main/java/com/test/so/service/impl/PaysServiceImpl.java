package com.test.so.service.impl;

import com.test.so.controller.TelephoneController;
import com.test.so.domain.Pays;
import com.test.so.repository.PaysRepository;
import com.test.so.service.PaysService;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author GDUVINAGE
 */
public class PaysServiceImpl implements PaysService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TelephoneController.class);

    @Autowired
    PaysRepository paysRepository;

    @Override
    public Pays findByNom(String nom) {
        Collection<Pays> payss = paysRepository.findByNom(nom);
        if (payss.size() > 1) {
            LOGGER.info("Plus d'un pays trouvé pour le nom: " + nom);
            return null;
        } else if (payss.size() == 0) {
            LOGGER.info("Pas de pays trouvé pour le nom: " + nom);
            return null;
        } else {
            return payss.iterator().next();

        }
    }

}
