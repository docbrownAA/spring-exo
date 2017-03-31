package com.test.so.controller;

import com.test.so.domain.Adresse;
import com.test.so.domain.Ville;
import com.test.so.service.AdresseService;
import com.test.so.service.VilleService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
@RequestMapping("/adresses")
public class AdresseController {

    @Autowired
    AdresseService adresseService;

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

}
