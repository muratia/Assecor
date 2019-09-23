package com.ahmetmurati.asserco.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "persons")
@JsonPropertyOrder({"id", "name", "lastname", "zipcode", "city", "color"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonPropertyOrder()
    private Long id;

    @Column(name = "name", length = 150)
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "lastname")
    private String lastName;
    @JsonProperty(value = "zipcode")
    private String zipCode;
    private String city;
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Integer color;


    public Person() {
    }

    public Person(Long id, String name, String lastName, String zipCode, String city) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @JsonProperty("color")
    public String getColorName() {
        String colName = "";
        switch (this.color) {
            case 1: {
                colName = "blue";
            }
            break;
            case 2: {
                colName = "green";
            }
            break;
            case 3: {
                colName = "purple";
            }
            break;
            case 4: {
                colName = "red";
            }
            break;
            case 5: {
                colName = "yellow";
            }
            break;
            case 6: {
                colName = "turquoise";
            }
            break;
            case 7: {
                colName = "white";
            }
            break;
        }
        return colName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals (getColor (), person.getColor ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getColor ());
    }
}
