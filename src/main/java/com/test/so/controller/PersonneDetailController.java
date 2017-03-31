package com.test.so.controller;

import com.test.so.domain.Personne;
import com.test.so.domain.PersonneDetail;
import com.test.so.service.PersonneDetailService;
import com.test.so.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gduvinage
 */
@RestController
@RequestMapping("personnes/{id_personne}/")
public class PersonneDetailController {

    @Autowired
    PersonneDetailService personneDetailService;

    @Autowired
    PersonneService personneService;

    @RequestMapping(method = RequestMethod.GET, value = "/personneDetail")
    public PersonneDetail readPersonneDetail(@PathVariable("id_personne") int idPersonne) {
        Personne personne = personneService.findById(idPersonne);
        if (personne != null) {
            return personneDetailService.findByPersonne(personne);
        } else {
            return null;
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PersonneDetail createPersonneDetail(@PathVariable("id_personne") int idPersonne, @RequestBody PersonneDetail personneDetail) {
        Personne personne = personneService.findById(idPersonne);
        if (personne != null) {
            personneDetail.setPersonne(personne);
            return personneDetailService.create(personneDetail);
        } else {
            return null;
        }
    }
    

}
