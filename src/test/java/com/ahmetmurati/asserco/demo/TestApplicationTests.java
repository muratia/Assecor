package com.ahmetmurati.asserco.demo;

import com.ahmetmurati.asserco.demo.entity.Person;
import com.ahmetmurati.asserco.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    private PersonService personService;


    @Test
    public void testGetUsersWithColor() {
        String color = "white";

        List<Person> persons = personService.findByColorName (color);
        boolean b = true;
        for (Person p : persons) {
            if (!p.getColorName ().equals (color)) {
                b = false;
                break;
            }
        }

        assertEquals (true, b);
    }

    @Test
    public void testGetAllUsers() {
        List<Person> persons = personService.loads ();
        assertEquals (true, persons.size () > 0);
    }

}
