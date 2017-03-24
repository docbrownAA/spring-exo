package com.test.so.service.impl;

import com.test.so.domain.Telephone;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.so.repository.TelephoneRepository;
import com.test.so.service.TelephoneService;

/**
 * Created by azizunsal on 24/02/15.
 */
@Service
public class TelephoneServiceImpl implements TelephoneService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TelephoneServiceImpl.class);

    @Autowired
    private TelephoneRepository telephoneRepository;

    @Override
    public Telephone findById(Integer id) {
        LOGGER.info("Find by id {}", id);
        return telephoneRepository.findOne(id);
    }

    @Override
    public Collection<Telephone> findAll() {
        LOGGER.info("Find all");
        return telephoneRepository.findAll();
    }

}
