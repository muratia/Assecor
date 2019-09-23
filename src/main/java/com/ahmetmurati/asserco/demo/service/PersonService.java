package com.ahmetmurati.asserco.demo.service;

import com.ahmetmurati.asserco.demo.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    Person find(Long id);

    Person save(Person p);

    List<Person> loads();

    List<Person> findByColor(Integer color);

    List<Person> findByColorName(String color);

    List<Person> save(List<Person> persons);
}
