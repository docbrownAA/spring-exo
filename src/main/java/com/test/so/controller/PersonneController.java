package com.test.so.controller;

import com.test.so.domain.Personne;
import com.test.so.service.PersonneService;
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
//http://localhost:8080/spring-rest/ex/bars?id=100&second=something
@RestController
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    PersonneService personneService;

    @RequestMapping(method = RequestMethod.GET, value = "/", params = {"nom", "prenom"})
    public Personne readPersonne(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
        return personneService.findByNomAndPrenom(nom, prenom);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Personne> readPersonnes() {
        return personneService.findAll();
    }
}
