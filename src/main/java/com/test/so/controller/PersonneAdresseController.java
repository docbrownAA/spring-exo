package com.test.so.controller;

import com.test.so.domain.PersonneAdresse;
import com.test.so.service.PersonneAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gduvinage
 */
@RestController
@RequestMapping("/personneadresse")
public class PersonneAdresseController {
    @Autowired
    PersonneAdresseService personneAdresseService;
    
    @RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<PersonneAdresse> associatePersonneAndAdresse(@RequestBody PersonneAdresse personneAdresse){
        
        return new ResponseEntity<>(personneAdresseService.save(personneAdresse),HttpStatus.OK);
    }
}
