package com.test.so.controller;

import com.test.so.domain.Telephone;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.test.so.service.TelephoneService;

/**
 * Created by azizunsal on 24/02/15.
 */

@RestController
@RequestMapping("/telephone")
public class TelephoneController {
    
    @Autowired
    private TelephoneService phoneSettingsService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TelephoneController.class);
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Telephone testById(@PathVariable Integer id) {
        LOGGER.info("Hello controller - test by id {}", id);
        return phoneSettingsService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Telephone> readPhoneSettings() {
        LOGGER.info("Hello controller - readPhoneSettings");
        return phoneSettingsService.findAll();
    }
}
