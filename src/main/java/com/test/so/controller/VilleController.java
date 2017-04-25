package com.test.so.controller;

import com.test.so.domain.Ville;
import com.test.so.service.VilleService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gduvinage
 */
@RestController
@RequestMapping("/villes")
public class VilleController {
        @Autowired
        VilleService villeService;
        
        @RequestMapping(method= RequestMethod.GET)
        public Collection<Ville> readVilles(){
            return villeService.findAll();
        }
        
        @RequestMapping(method = RequestMethod.GET, value="/{id}")
        public ResponseEntity<Ville> readOne(@PathVariable Integer id){
            return new ResponseEntity(villeService.findById(id),HttpStatus.OK);
        }
}
