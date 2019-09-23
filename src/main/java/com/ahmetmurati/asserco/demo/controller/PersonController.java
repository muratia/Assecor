package com.ahmetmurati.asserco.demo.controller;

import com.ahmetmurati.asserco.demo.entity.Person;
import com.ahmetmurati.asserco.demo.processor.CvsProcessor;
import com.ahmetmurati.asserco.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    Logger logger = LoggerFactory.getLogger (PersonController.class);
    @Autowired
    private PersonService personService;

    @PostMapping(value = "", produces = "application/json")
    public List<Person> initializDb() throws IOException {
        CvsProcessor cvsProcessor = new CvsProcessor ();

        String fileName = "data.csv";
        File file = new ClassPathResource (fileName).getFile ();
        logger.debug ("The path: " + file.getPath ());
        List<Person> persons = cvsProcessor.read (file.getPath ());

        persons = personService.save (persons);
        return persons;
    }

    @GetMapping(value = "", produces = "application/json")
    public List<Person> getPersons() {

        List<Person> persons = personService.loads ();

        return persons;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Person searchById(@PathVariable Long id) {
        logger.error ("Id = " + id);
        // Person person = personService.find (id);
        return personService.find (id);

    }

    @GetMapping(value = "color/{color}", produces = "application/json")
    @ResponseBody
    public List<Person> searchByColor(@PathVariable String color) {
        List<Person> persons = new ArrayList<> ();
        persons = personService.findByColorName (color);
        return persons;

    }
}
