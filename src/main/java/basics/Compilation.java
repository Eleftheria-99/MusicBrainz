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
import java.util.*;

/**
 *
 * @author it21735/it21754/it217130
 */
public class Compilation extends Release {

    public List<Release> CompSongs = new ArrayList<>();
    public List<Artist> Artists = new ArrayList<>();
    protected int id;

    //add element in list: Artists, every element has its unique id 
    public void add_element_to_list_Artists(Artist i) {
        // id =i.to_increase_id();
        Artists.add(i);
        //Characteristics  r =new Characteristics();
        //Artists.add( new Characteristics (Name , Country,Cities, id ));
    }

    //add element in list: CompSongs
    public void add_element_to_list_CompSongs(String Title, String Status, String Language, String ReleaseDate, String Format, int TrackCount) {
        Artist i = new Artist();
        id = i.to_increase_id();
        CompSongs.add(new Release(Title, Status, Language, ReleaseDate, Format, TrackCount, id));
    }

    //Getters and Setters
    public List<Release> getCompSongs() {
        return CompSongs;
    }

    public void setCompSongs(List<Release> CompSongs) {
        this.CompSongs = CompSongs;
    }

    public List<Artist> getArtists() {
        return Artists;
    }

    public void setArtists(List<Artist> Artists) {
        this.Artists = Artists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//default constructor
    public Compilation() {
    }

    //constructopr
    public Compilation(List<Release> CompSongs, List<Artist> Artists, int id) {
        this.CompSongs = CompSongs;
        this.Artists = Artists;
        this.id = id;
    }

}
