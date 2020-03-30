/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import tests.*;
import files.*;
import db.*;

import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors it21735it21754/it217130
 */
public class Artist implements Serializable {

    protected String Name;
    public String Country;
    protected String Cities;
    protected String Gender;  //only if Artist is a single Person
    protected String Type;

    protected int id;

    public List<String> Aliases = new ArrayList<>(); //for group and person
    public List<String> Tags = new ArrayList<>();    //for group and person

    static AtomicInteger codeSequence = new AtomicInteger();  //Creates a new AtomicInteger with initial value 0

    //constructor
    public Artist(String Name, String Country, String Cities, String Gender, int id) {
        this.Name = Name;
        this.Country = Country;
        this.Cities = Cities;
        this.Gender = Gender;
        this.id = id;
    }

    //default constructor
    public Artist() {
    }

    //Getters
    public String getGender() {
        return Gender;
    }

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public String getCities() {
        return Cities;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return Type;
    }

    //Setters
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setCities(String Cities) {
        this.Cities = Cities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    //method to increase id by 1 every time that is being used 
    public int to_increase_id() {
        id = codeSequence.incrementAndGet();
        return id;
    }

    protected Date stringToDAte(String date) {   //the method converts the given date from string to date format
        Date newdate = null;
        try {
            newdate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Artist.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newdate;
    }

    public Artist(String Name, String Country, String Type, String Gender) {
        this.Name = Name;
        this.Country = Country;
        this.Gender = Gender;
        this.Type = Type;
    }

}
