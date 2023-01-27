package br.com.gabrielalencar.restwithspringbootandjava.controllers;

import br.com.gabrielalencar.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.gabrielalencar.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.gabrielalencar.restwithspringbootandjava.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
    private final AtomicLong counter = new AtomicLong();
/***********************************************************************************************************/
    @Autowired
    private PersonServices service;
/***********************************************************************************************************/
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public br.com.gabrielalencar.restwithspringbootandjava.data.vo.v1.PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {

        return service.findById(id);
    }
/***********************************************************************************************************/
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List <PersonVO> findAll() {
        return service.findAll();
    }
/***********************************************************************************************************/
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonVO create(@RequestBody PersonVO person) {
        return service.create(person);
    }
/***********************************************************************************************************/
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonVO update(@RequestBody PersonVO person) {
        return service.update(person);
    }
/***********************************************************************************************************/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
/***********************************************************************************************************/
// V2 - Adicionado Campo birthday Date
    @PostMapping(value = "/v2",
                    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonVOV2 createV2(@RequestBody PersonVOV2 personVOV2) {
        return service.createV2(personVOV2);
    }
}
