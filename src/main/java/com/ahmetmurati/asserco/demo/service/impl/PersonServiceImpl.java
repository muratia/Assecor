package com.ahmetmurati.asserco.demo.service.impl;

import com.ahmetmurati.asserco.demo.entity.Person;
import com.ahmetmurati.asserco.demo.repository.PersonRepository;
import com.ahmetmurati.asserco.demo.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    public final PersonRepository repository;


    public PersonServiceImpl(PersonRepository repo) {
        this.repository = repo;
    }


    @Override
    public Person find(Long id) {
        Optional<Person> p = this.repository.findById (id);
        return p.get ();
    }


    @Override
    public Person save(Person p) {
        return this.repository.save (p);
    }

    @Override
    public List<Person> loads() {
        return this.repository.findAll ();
    }

    @Override
    public List<Person> findByColor(Integer color) {
        return this.repository.findByColor (color);
    }

    @Override
    public List<Person> findByColorName(String color) {
        int colInt = 0;
        switch (color) {
            case "blue": {
                colInt = 1;
            }
            break;
            case "green": {
                colInt = 2;
            }
            break;
            case "purple": {
                colInt = 3;
            }
            break;
            case "red": {
                colInt = 4;
            }
            break;
            case "yellow": {
                colInt = 5;
            }
            break;
            case "turquoise": {
                colInt = 6;
            }
            break;
            case "white": {
                colInt = 7;
            }
            break;

        }


        return this.findByColor (colInt);
    }

    @Override
    public List<Person> save(List<Person> persons) {
        return this.repository.saveAll (persons);
    }
}
