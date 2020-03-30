/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import basics.*;
import tests.*;
import db.*;

import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it21735/it21754/it217130
 */
public class FileWrapper {

    public void writeArtistObjectToFile(String filename, ArrayList<Artist> arraylist) {

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

//            for (Artist a : arraylist) {
//                System.out.println(a.getName() + "\t\t" + a.getType() + "\t\t" + a.getGender() + "\t" + a.getCountry() + "\t");
//            }
            for (int i = 0; i <= arraylist.size(); i++) {
                oos.writeObject(arraylist);   // write  in the file
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void writeReleaseObjectToFile(String filename, ArrayList<Release> arraylist) {  //JSONObject object  List<Object> arraylist, the method writes the json-objects from the arraylist into the json file
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

//            for (Release a : arraylist) {
//                System.out.println(a.getTitle() + "," + a.getStatus() + "," + a.getCountry() + "," + a.getFormat() + "," + a.getReleaseDate() + "," + a.getTrackCount());
//            }
            oos.writeObject(arraylist);   // write  in the file

            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static ArrayList<Artist> ObjectArray = new ArrayList<>();

    protected static ArrayList<Artist> readfromJsonFile(String namefile) {  //the method reads from the json file and returns an array from json objects        
        ObjectInputStream ois = null;
        try {
            // create an ObjectInputStream for the file we created before
            ois = new ObjectInputStream(new FileInputStream(namefile));

            ObjectArray = (ArrayList<Artist>) ois.readObject(); // read and print an object and put into an arraylist

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(FileWrapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ObjectArray;
    }

}
