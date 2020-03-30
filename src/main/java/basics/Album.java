
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import tests.*;
import files.*;
import db.*;

import java.util.*;

/**
 *
 * @authors it21735/it21754/it217130
 */
public class Album extends Release {

    protected Artist Artist;
    public List<Release> list_Album = new ArrayList<>();
    protected int id;

    //method to add element to list Album
    public void add_element_to_list_Album(String Title, String Status, String Language, String ReleaseDate, String Format, int TrackCount) {
        Artist i = new Artist();
        id = i.to_increase_id();
        list_Album.add(new Release(Title, Status, Language, ReleaseDate, Format, TrackCount, id));
    }

    //getters
    public Artist getArtist() {
        return Artist;
    }

    public List<Release> getAlbum() {
        return list_Album;
    }

    public int getId() {
        return id;
    }

    //setters
    public void setArtist(Artist Artist) {
        this.Artist = Artist;
    }

    public void setList_Album(List<Release> list_Album) {
        this.list_Album = list_Album;
    }

    public void setAlbum_id(int id) {
        this.id = id;
    }

    //constructor
    public Album(Artist Artist, int id) {
        this.Artist = Artist;
        this.id = id;
    }

    //default constructor
    public Album() {
    }

}
