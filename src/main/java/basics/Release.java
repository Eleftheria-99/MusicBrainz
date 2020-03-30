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
public class Release implements Serializable {

    protected String Title;
    protected String Status;  //official or unofficial 
    protected String Country;
    protected String ReleaseDate;
    protected String Format;
    protected int TrackCount;
    protected int id;

    //Getters and Setters
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getStatus() {
        return Status;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String Format) {
        this.Format = Format;
    }

    public int getTrackCount() {
        return TrackCount;
    }

    public void setTrackCount(int TrackCount) {
        this.TrackCount = TrackCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //default constructor
    public Release() {
    }

    //constructor
    public Release(String Title, String Status, String Language, String ReleaseDate, String Format, int TrackCount, int id) {
        this.Title = Title;
        this.Status = Status;
        this.Country = Language;
        this.ReleaseDate = ReleaseDate;
        this.Format = Format;
        this.TrackCount = TrackCount;
        this.id = id;
    }

    public Release(String Title, String Status, String Country, String ReleaseDate, String Format) {
        this.Title = Title;
        this.Status = Status;
        this.Country = Country;
        this.ReleaseDate = ReleaseDate;
        this.Format = Format;
    }

}
