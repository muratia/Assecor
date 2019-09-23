package com.ahmetmurati.asserco.demo.repository;

import com.ahmetmurati.asserco.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByColor(Integer color);
}
