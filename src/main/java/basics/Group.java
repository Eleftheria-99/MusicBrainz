/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import tests.*;
import files.*;
import db.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @authors it21735/it21754/it217130
 */
public class Group extends Artist {

    protected Date BeginDate;
    protected Date EndDate;
    public List<String> Members = new ArrayList<>(); //list with the members of each group   

    //Getters
    public Date getBeginDate() {
        return BeginDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public List<String> getMembers() {
        return Members;
    }

    //Setters
    public void setBeginDate(Date BeginDate) {
        this.BeginDate = BeginDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public void setMembers(List<String> Members) {
        this.Members = Members;
    }

    //default constructor
    public Group() {
    }

    public Group(Date BeginDate, Date EndDate, List<String> Members) { //constructor
        this.BeginDate = BeginDate;
        this.EndDate = EndDate;
        this.Members = Members;
    }

    //constructor of super class Artist
    public Group(String Name, String Country, String Cities, String Gender, int id) {
        super(Name, Country, Cities, Gender, id);
    }

    public Group(Date BeginDate, Date EndDate, String Name, String Country, String Cities, int id) {
        //super(Name, Country, Cities, Gender, id);
        this.BeginDate = BeginDate;
        this.EndDate = EndDate;
    }

}
