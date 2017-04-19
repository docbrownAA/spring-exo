package com.test.so.controller;

import com.test.so.domain.Personne;
import com.test.so.domain.PersonneDetail;
import com.test.so.service.PersonneDetailService;
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

    @Autowired
    PersonneDetailService personneDetailService;

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
        PersonneDetail personneDetail = personne.getPersonneDetail();
        personne.setPersonneDetail(null);
        Personne persNew = personneService.create(personne);
        if (personneDetail != null) {
            personneDetail.setPersonne(persNew);
            PersonneDetail pdNew = personneDetailService.create(personneDetail);
            persNew.setPersonneDetail(pdNew);
        }
        return new ResponseEntity(personneService.update(persNew), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/{id_personne}")
    public ResponseEntity updatePersonne(@PathVariable("id_personne") Integer id_personne, @RequestBody Personne personne) {
        Personne currPersonne = personneService.findById(id_personne);
        currPersonne = managePersonne(currPersonne, personne);

        PersonneDetail persDetFromDB = personneDetailService.findByPersonne(personne);
        PersonneDetail persDetFromCli = personne.getPersonneDetail();
        if (persDetFromDB == null) {
            if (persDetFromCli != null) {
                persDetFromCli.setPersonne(currPersonne);
                PersonneDetail pdNew = personneDetailService.create(persDetFromCli);
                currPersonne.setPersonneDetail(pdNew);
            }
        } else {
            persDetFromDB.setNumSecu(persDetFromCli.getNumSecu());
            persDetFromDB.setSexe(persDetFromCli.getSexe());
            PersonneDetail pdUp = personneDetailService.save(persDetFromDB);
            currPersonne.setPersonneDetail(pdUp);
        }
        return new ResponseEntity(personneService.update(currPersonne), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/personne/{id_personne}")
    public ResponseEntity delete(@PathVariable("id_personne") int idPersonne) {
        Personne personne = personneService.findById(idPersonne);
        if (personne == null) {
            System.out.println("Impossible de trouver la personne:" + idPersonne);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        PersonneDetail pdToDelete = personne.getPersonneDetail();
        if (pdToDelete != null) {
            personneDetailService.delete(pdToDelete.getId());
            personne.setPersonneDetail(null);
        }
        personneService.delete(personne);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private Personne managePersonne(Personne fromDataBase, Personne fromClient) {
            fromDataBase.setNom(fromClient.getNom());
            fromDataBase.setPrenom(fromClient.getPrenom());
            fromDataBase.setDate_naissance(fromClient.getDate_naissance());

        return fromDataBase;

    }

}
