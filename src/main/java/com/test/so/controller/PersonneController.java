package com.test.so.controller;

import com.test.so.domain.Personne;
import com.test.so.service.PersonneService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/personnes")
public class PersonneController {

    @Autowired
    PersonneService personneService;

    @RequestMapping(method = RequestMethod.GET, value = "/personne", params = {"nom", "prenom"})
    public Personne readPersonne(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
        return personneService.findByNomAndPrenom(nom, prenom);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Personne> readPersonnes() {
        return personneService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id_personne}")
    public Personne readOnePersonne(@PathVariable("id_personne") int idPersonne) {
        return personneService.findById(idPersonne);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createPersonne(@RequestBody Personne personne) {
        return new ResponseEntity(personneService.create(personne), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/personne/{id_personne}")
    public ResponseEntity delete(@PathVariable("id_personne") int idPersonne) {
        Personne personne = personneService.findById(idPersonne);
        if (personne == null) {
            System.out.println("Impossible de tourver la personne:" + idPersonne);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        personneService.delete(personne);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
