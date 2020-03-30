/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import basics.*;
import files.*;
import tests.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it21735/it21754/it217130
 */
public class Database {    //through this class the project connects with the oracle database using JDBC

    protected ArrayList<Artist> ArtistsFromDatabase = new ArrayList<>();
    protected ArrayList<Release> ReleasesFromDatabase = new ArrayList<>();

    protected Connection connection = null;
    protected Statement stmt = null;
    protected PreparedStatement pstmt = null;

    String execute = null;

    String name = null;
    String country = null;
    String gender = null;  //gender will be null when type is group
    String type = null;     //type will be null when type is solo artist, type =group when type is group

    Artist a = new Artist();
    Release r = new Release();

    // attributes for executeQuerySearchBasedOnArtistName,  executeQuerySearchBasedOnCountry
    String artist_type = null;
    String artist_name = null;
    String artist_gender = null;
    String artist_country = null;

    // attributes for executeQuerySearchBasedOnReleaseTitle
    String Release_title = null;
    String Release_status = null;
    String Release_date = null;
    String Release_format = null;
    String Release_country = null;

    public void establishConnection() {

        try {     //load database driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger("Driver not found");
            System.out.println(ex);
            System.out.println("loading database driver error");
        }

        try {   //establich connection with the database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl", "it21754", "it21754");
            connection.setAutoCommit(false); //Set auto commit as false.
        } catch (SQLException ex) {
            Logger.getLogger("Server not found");
            System.out.println(ex);
        }
        //  System.out.println("CONNECTED WITH ORACLE HUA DATABASE!");
    }

    public void insertIntoArtist(ArrayList<Artist> arraylist) { //when a url returns json, the main attributes will be saved also in the database! This method is being called by execute method in APIWrapper.
        establishConnection();

        //Values of table Artist : type, name, gender, country
        String query = "INSERT INTO Artist VALUES (?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(query);

            for (Artist ar : arraylist) {

                name = a.getName();
                country = ar.getCountry();
                gender = ar.getGender();
                type = ar.getType();

                pstmt.setString(1, type);
                pstmt.setString(2, name);
                pstmt.setString(3, gender);
                pstmt.setString(4, country);
                pstmt.executeUpdate();
                connection.commit();             //Commit data here.
            }
            pstmt.executeUpdate();

//            System.out.println("Record is inserted into table!");
//            System.out.println("commit done");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep.getMessage());
                }
            }
        } finally {

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void insertIntoTableReleases(ArrayList<Release> arraylist) {
        establishConnection();
        //Values of  table Releases:title, status, Release_date, country , format
        String title = null;
        String status = null;  //official or unofficial 
        String countryy = null;
        String releaseDate = null;
        String format = null;
        try {

            String query = "INSERT INTO Releases VALUES (?,?,?,?,?)";
            pstmt = connection.prepareStatement(query);

            for (int f = 0; f < arraylist.size(); f++) {      //for (Release a : arraylist) 
                r = arraylist.get(f);

                title = r.getTitle();
                status = r.getStatus();
                releaseDate = r.getReleaseDate();
                countryy = r.getCountry();
                format = r.getFormat();

                pstmt.setString(1, title);
                pstmt.setString(2, status);
                pstmt.setString(3, releaseDate);
                pstmt.setString(4, countryy);
                pstmt.setString(5, format);

                pstmt.executeUpdate();
                connection.commit();             //Commit data here.
            }

//            System.out.println("Record is inserted into table!");
//            System.out.println("commit done");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());

            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep.getMessage());
                }
            }
        } finally {

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Artist> executeQuerySearchBasedOnArtistName(String givensearchword) { //based on the given artist name , the method searches the database and returns all thes lines where the given artist name is found
        establishConnection();
        execute = "select distinct artist_type, artist_name, artist_gender, artist_country from Artist where artist_name like '%" + givensearchword + "%'";

        try {
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            ResultSet rs = stmt.executeQuery(execute);  //executing query
            while (rs.next()) {
                //System.out.println("\nartist_type:" + rs.getString("artist_type") + "\nartist_name:" + rs.getString(2) + "\nartist_gender:" + rs.getString(3) + "\nartist_country:" + rs.getString(4));

                this.artist_type = rs.getString("artist_type");
                if (this.artist_type == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_type = "null"; // set it to empty string as you desire. rs.wasNull() 
                }
                this.artist_name = rs.getString("artist_name");
                if (this.artist_name == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_name = "null"; // set it to empty string as you desire.
                }
                this.artist_gender = rs.getString("artist_gender");
                if (this.artist_gender == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_gender = "null"; // set it to empty string as you desire.
                }

                this.artist_country = rs.getString("artist_country");
                if (this.artist_country == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_country = "null"; // set it to empty string as you desire.
                }
                ArtistsFromDatabase.add(new Artist(artist_name, artist_country, artist_gender, artist_type));   //attributes of every object of the array :String Name, String Country, String Gender, String Type
            }
//            System.out.println("into the arraylist");
//            ArtistsFromDatabase.forEach(st -> System.out.println("\n Name : " + st.getName() + "\n Country : " + st.getCountry() + "\nGender : " + st.getGender() + "\nType : " + st.getType()));
            return ArtistsFromDatabase;

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println(ex.getMessage());

        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ArtistsFromDatabase;
    }

    public ArrayList<Artist> executeQuerySearchBasedOnCountry(String givensearchword) throws SQLException {
        establishConnection();
        execute = "select distinct artist_type, artist_name, artist_gender, artist_country from Artist where artist_country like '%" + givensearchword + "%'";

        try {
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            ResultSet rs = stmt.executeQuery(execute);
            while (rs.next()) {
                //System.out.println("\nartist_type:" + rs.getString(1) + "\nartist_name:" + rs.getString(2) + "\nartist_gender:" + rs.getString(3) + "\nartist_country:" + rs.getString(4));

                this.artist_type = rs.getString("artist_type");
                if (this.artist_type == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_type = ""; // set it to empty string as you desire. rs.wasNull() 
                }
                artist_name = rs.getString("artist_name");
                if (this.artist_name == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_name = "null"; // set it to empty string as you desire.
                }
                artist_gender = rs.getString("artist_gender");
                if (this.artist_gender == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_gender = "null"; // set it to empty string as you desire.
                }
                artist_country = rs.getString("artist_country");
                if (this.artist_country == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_country = "null"; // set it to empty string as you desire.
                }
                ArtistsFromDatabase.add(new Artist(artist_name, artist_country, artist_gender, artist_type));   //attributes of every object of the array :String Name, String Country, String Gender, String Type) 
            }
            return ArtistsFromDatabase;

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println(ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ArtistsFromDatabase;
    }

    public ArrayList<Artist> executeQuerySearchBasedOnGroupName(String givensearchword) {

        establishConnection();
        //in this case artist_type will be group
        execute = "select distinct artist_type, artist_name, artist_gender, artist_country from Artist where artist_name like '%" + givensearchword + "%' and artist_type='Group'";

        try {
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            ResultSet rs = stmt.executeQuery(execute);
            while (rs.next()) {
                System.out.println("\nartist_type:" + rs.getString("artist_type") + "\nartist_name:" + rs.getString(2) + "\nartist_gender:" + rs.getString(3) + "\nartist_country:" + rs.getString(4));

                this.artist_type = rs.getString("artist_type");
                if (this.artist_type == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_type = "null"; // set it to empty string 
                }
                this.artist_name = rs.getString("artist_name");
                if (this.artist_name == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_name = "null"; // set it to empty string 
                }
                this.artist_gender = rs.getString("artist_gender");
                if (this.artist_gender == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_gender = "null"; // set it to empty string 
                }
                this.artist_country = rs.getString("artist_country");
                if (this.artist_country == null) {   //if the value, that has been returned from the database, is bull
                    this.artist_country = "null"; // set it to empty string 
                }
                ArtistsFromDatabase.add(new Artist(artist_name, artist_country, artist_gender, artist_type));   //attributes of every object of the array :String Name, String Country, String Gender, String Type) 
            }
            return ArtistsFromDatabase;
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println(ex.getMessage());

        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ArtistsFromDatabase;
    }

    public ArrayList<Release> executeQuerySearchBasedOnReleaseTitle(String givensearchword) { //based on the given artist name , the method searches the database and returns all thes lines where the given artist name is found
        establishConnection();

        execute = "select distinct Release_title,Release_status, Release_date, Release_format,Release_country  from Releases where Release_title like '%" + givensearchword + "%'";
        try {
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            ResultSet rs = stmt.executeQuery(execute);

            while (rs.next()) {
                //System.out.println("\nRelease_title:" + rs.getString(1) + "\nRelease_status:" + rs.getString(2) + "\nRelease_date:" + rs.getString(3) + "\nRelease_format:" + rs.getString(4) + "\nRelease_country:" + rs.getString(4));

                Release_title = rs.getString(1); //rs.getString(" Release_title");
                Release_status = rs.getString(2); //rs.getString("Release_status");
                Release_date = rs.getString(3); //rs.getString("Release_date");
                Release_format = rs.getString(4); //rs.getString("Release_format");
                Release_country = rs.getString(5); //rs.getString("Release_country");
                ReleasesFromDatabase.add(new Release(Release_title, Release_status, Release_date, Release_format, Release_country));   //attributes of every object of the array :String Name, String Country, String Gender, String Type) 

            }
            // ReleasesFromDatabase.forEach(st -> System.out.println("\n Title : " + st.getTitle() + "\n Status : " + st.getStatus() + "\n Country : " + st.getCountry() + "\n Release Date : " + st.getReleaseDate()+ "\n Format: " + st.getFormat() ));

            return ReleasesFromDatabase;
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println(ex.getMessage());

        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ReleasesFromDatabase;
    }
}
