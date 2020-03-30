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
import java.util.Date;

/**
 *
 * @authors it21735/it21754/it217130
 */
public class Person extends Artist implements Serializable {

    protected Date BirthDate;
    protected Date DeathDate;

    //Getters
    public Date getBirthDate() {
        return BirthDate;
    }

    public Date getDeathDate() {
        return DeathDate;
    }

    //Setters
    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public void setDeathDate(Date DeathDate) {
        this.DeathDate = DeathDate;
    }

    //default constructor
    public Person() {
    }

    //constructor
    public Person(Date BirthDate, Date DeathDate) {
        this.BirthDate = BirthDate;
        this.DeathDate = DeathDate;
    }

    //constructor of super class Artist
    public Person(String Name, String Country, String Cities, String Gender, int id) {
        super(Name, Country, Cities, Gender, id);
    }

    public Person(String Gender, Date BirthDate, Date DeathDate, String Name, String Country, String Cities, int id) {
        super(Name, Country, Cities, Gender, id);
        this.Gender = Gender;
        this.BirthDate = BirthDate;
        this.DeathDate = DeathDate;
    }

}
