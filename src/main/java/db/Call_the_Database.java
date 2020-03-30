/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import basics.*;
import files.*;
import tests.*;

/**
 *
 * @author it21735/it21754/it217130
 */
public class Call_the_Database {

    public void callDatabase() {

        Database db = new Database();
        //the methods search for the given word(artist name or release title in the daatbase an return every line where the given word is found )
        db.executeQuerySearchBasedOnArtistName("Jennifer");
        db.executeQuerySearchBasedOnArtistName("One");
        db.executeQuerySearchBasedOnGroupName("One-Direction");
        db.executeQuerySearchBasedOnReleaseTitle("Schneider");

    }
}
