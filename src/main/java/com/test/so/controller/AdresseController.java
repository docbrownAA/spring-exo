package com.test.so.controller;

import com.test.so.domain.Adresse;
import com.test.so.domain.PersonneAdresse;
import com.test.so.service.AdresseService;
import com.test.so.service.PersonneAdresseService;
import com.test.so.service.VilleService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gduvinage
 */
@RestController
@RequestMapping("/adresses")
public class AdresseController {

    @Autowired
    AdresseService adresseService;
    
    @Autowired
    PersonneAdresseService personneAdresseService;

    @Autowired
    VilleService villeService;

    @RequestMapping(method = RequestMethod.GET, value = "/adresse", params = {"libelle"})
    public Collection<Adresse> readAdresse(@RequestParam("libelle") String libelle) {
        return adresseService.findByLibelleContaining(libelle);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Adresse> readAllAdresses() {
        return adresseService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"ville"})
    public Collection<Adresse> readAdressesByVille(@RequestParam("ville") String ville) {
        return adresseService.findByVilleNom(ville);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity createAdresse(@RequestBody  Adresse adresse){
        return new ResponseEntity(adresseService.save(adresse),HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, value="/lien")
    public ResponseEntity linkPersonneAdresse(@RequestBody PersonneAdresse personneAdresse){
        return new ResponseEntity(personneAdresseService.save(personneAdresse), HttpStatus.CREATED);
    }

}
