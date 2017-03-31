package com.test.so.controller;

import com.test.so.domain.Pays;
import com.test.so.service.PaysService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gduvinage
 */
@RestController
@RequestMapping("/pays")
public class PaysController{
    @Autowired
    PaysService paysService;
    
     @RequestMapping(method = RequestMethod.GET, value = "/pays", params = {"nom"})
    public Pays readPays(@RequestParam("nom") String nom) {
        return paysService.findByNom(nom);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Pays> readPays() {
        return paysService.findAll();
    }
}
