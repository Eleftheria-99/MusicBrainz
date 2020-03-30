/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import basics.*;
import tests.*;
import db.*;

import java.net.*;
import java.io.*;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

/**
 *
 * @author it21735/it21754/it217130
 */
public class APIWrapper {              //here there are the API methods 

    protected final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36";
    protected ArrayList<Artist> ArtistArray = new ArrayList<>();
    protected ArrayList<Release> ReleaseArray = new ArrayList<>();

    Database database = new Database();
    FileWrapper wr = new FileWrapper();

    //attributes for Artist objects
    Artist p1 = new Person();
    String name = null;
    String country = null;
    String gender = null;  //gender will be null when type is group
    String type;    //type will be null when type is solo artist, type =group when type is group

    //variables for Release objects
    String title = null;
    String status = null;  //official or unofficial 
    // String country = null;
    String releaseDate = null;
    String format = null;

    public ArrayList<Artist> searchForNameGroup(String name) { //method is searching based on the name group
        try {
            sendGet(urlNameGroup(name));
        } catch (Exception ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return execute_method_for_Group_Artist(urlNameGroup(name));
    }

    public ArrayList<Artist> searchForArtistName(String name) { //method is searching based on an artist's name
        try {
            sendGet(urlNameArtist(name));
        } catch (Exception ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return execute_method_for_Artist(urlNameArtist(name));
    }

    public ArrayList<Artist> searchForCountry(String country) {   //method is searching based on the country 
        try {
            sendGet(urlCountry(country));
        } catch (Exception ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return execute_method_for_Artist_based_on_Country(urlCountry(country));
    }

    public ArrayList<Release> search_for_Release(String release) {  //method is searching based on the release name
        try {
            sendGet(urlRelease(release));
        } catch (Exception ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return execute_method_for_Release(urlRelease(release));

    }

    protected ArrayList<Artist> execute_method_for_Artist(String parameterForUrl) {    //calls the methods, in order to read what the url returned, to write into a json file and to read from jsonfile
        JSONObject json = readJsonFromUrl(parameterForUrl);
        // System.out.println(json);

        try {
            wr.writeArtistObjectToFile("file.txt", convert_json_person_object_to_artirst_and_put_into_arraylist(json));   //convert_json_object_to_arraylist(readJsonFromUrl(parameterForUrl))
            FileWrapper.readfromJsonFile("file.txt");  //the method reads the file where I saved whatever the url returned  
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("error");
        }
        database.insertIntoArtist(convert_json_person_object_to_artirst_and_put_into_arraylist(json)); //saving the information that the url returned into database

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convert_json_person_object_to_artirst_and_put_into_arraylist(json);
    }

    protected ArrayList<Artist> execute_method_for_Group_Artist(String parameterForUrl) {    //calls the methods, in order to read what the url returned, to write into a json file and to read from jsonfile
        JSONObject json = readJsonFromUrl(parameterForUrl);
        //System.out.println(json);

        try {
            wr.writeArtistObjectToFile("file.txt", convert_json_Group_object_to_artirst_and_put_into_arraylist(json));   //convert_json_object_to_arraylist(readJsonFromUrl(parameterForUrl))
            FileWrapper.readfromJsonFile("file.txt");  //the method reads the file where I saved whatever the url returned  
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("error");
        }
        database.insertIntoArtist(convert_json_Group_object_to_artirst_and_put_into_arraylist(json)); //saving the information that the url returned into database

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convert_json_person_object_to_artirst_and_put_into_arraylist(json);
    }

    protected ArrayList<Artist> execute_method_for_Artist_based_on_Country(String parameterForUrl) {    //calls the methods, in order to read what the url returned, to write into a json file and to read from jsonfile
        JSONObject json = readJsonFromUrl(parameterForUrl);
        //System.out.println(json);

        try {
            wr.writeArtistObjectToFile("file.txt", convert_json_object_based_on_country_to_artirst_and_put_into_arraylist(json));   //convert_json_object_to_arraylist(readJsonFromUrl(parameterForUrl))
            FileWrapper.readfromJsonFile("file.txt");  //the method reads the file where I saved whatever the url returned  
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("error");
            throw new RuntimeException(ex);
        }
        database.insertIntoArtist(convert_json_object_based_on_country_to_artirst_and_put_into_arraylist(json)); //saving the information that the url returned into database
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convert_json_object_based_on_country_to_artirst_and_put_into_arraylist(json);
    }

    protected ArrayList<Release> execute_method_for_Release(String parameterForUrl) {    //calls the methods, in order to read what the url returned, to write into a json file and to read from jsonfile
        JSONObject json = null;
        json = readJsonFromUrl(parameterForUrl);

        //System.out.println(json);
        try {
            wr.writeReleaseObjectToFile("file.txt", convert_json_object_to_release_and_put_into_arraylist(json));   //convert_json_object_to_arraylist(readJsonFromUrl(parameterForUrl))
            FileWrapper.readfromJsonFile("file.txt");  //the method reads the file where I saved whatever the url returned  
        } catch (Exception ex) {
            System.out.println(ex);
        }
        database.insertIntoTableReleases(convert_json_object_to_release_and_put_into_arraylist(json));//information of url saved into the database
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convert_json_object_to_release_and_put_into_arraylist(json);
    }

    // Creating URL Strings
    protected String urlNameGroup(String name) {
        String url_site = "http://musicbrainz.org/ws/2/artist/?query=artist:" + name + "%20AND%20type:group&fmt=json";
        return url_site;
    }

    protected String urlNameArtist(String name) {
        String url = "http://musicbrainz.org/ws/2/artist/?query=artist:" + name + "&fmt=json";
        return url;
    }

    protected String urlCountry(String Country) {
        String url = "http://musicbrainz.org/ws/2/area/?query=%22" + Country + "%22&fmt=json";
        return url;
    }

    protected String urlRelease(String keyword) {
        String url = "http://musicbrainz.org/ws/2/release/?query=release:" + keyword + "&fmt=json";

        return url;
    }

    protected void sendGet(String url) {   // HTTP GET request  

        URL obj = null;
        try {
            obj = new URL(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // System.out.println("\nSending 'GET' request to URL : " + url);

            //creating a GET request
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            //Configuring Timeouts, HttpUrlConnection class allows setting the connect and read timeouts
            //we have set both timeout values to 5 seconds
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            // System.out.println("Connected with the url!");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Connection failed!Cannot connect with the url!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Connection failed!Cannot connect with the url!");
        }
    }

    protected static String readAll(Reader rd) throws IOException {    //Reading the URL Response

        StringBuilder sb = new StringBuilder();
        int cp;

        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) { //the method reads what the url returned, "puts" it into a json object and returns the json object
        JSONParser parser = new JSONParser();
        JSONObject json = null;            //initializing jsonobject

        try {
            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);    //reading everything that the url returned
            json = (JSONObject) parser.parse(jsonText); //string To Parse = jsonText
            //close inputstream

            return json;                                   //returns 1 jsonobject that contains everything that the url returned  
        } catch (IOException | ParseException ex) {
            Logger.getLogger(APIWrapper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return json;                    //returns 1 jsonobject that contains everything that the url returned  
        }
    }

    public ArrayList<Artist> convert_json_person_object_to_artirst_and_put_into_arraylist(JSONObject jsonObject) {  //the method converts the json object to artist object and puts  the artist object into arraylist
        Artist artist = new Artist();

        JSONArray json_artists_list_ = (JSONArray) jsonObject.get("artists"); //the array named artists from the json object is being put into an arraylist 

        for (int i = 0; i < json_artists_list_.size(); i++) {

            JSONObject json_artist = (JSONObject) json_artists_list_.get(i);
            type = (String) json_artist.get("type");  //type = null
            name = (String) json_artist.get("name");
            gender = ((String) json_artist.get("gender"));
            country = (String) json_artist.get("country");

            ArtistArray.add(new Artist(name, country, type, gender, artist.to_increase_id()));  //add into the array a new object 
        }

        //ArtistArray.forEach(st -> System.out.println("\n Name : " + st.getName() + "\n Country : " + st.getCountry() + "\nGender : " + st.getGender() + "\nType : " + st.getType()));
        return ArtistArray; //the method returns the array
    }

    public ArrayList<Artist> convert_json_Group_object_to_artirst_and_put_into_arraylist(JSONObject jsonObject) {  //the method converts the json object to artist object and puts  the artist object into arraylist

        Artist artist = new Artist();

        JSONArray json_artists_list_ = (JSONArray) jsonObject.get("artists"); //the array named artists from the json object is being put into an arraylist 

        for (int i = 0; i < json_artists_list_.size(); i++) {

            JSONObject json_artist = (JSONObject) json_artists_list_.get(i);

            type = "Group";                        //type = (String) json_artist.get("type");   
            name = (String) json_artist.get("name");
            gender = ((String) json_artist.get("gender"));
            country = (String) json_artist.get("country");

            ArtistArray.add(new Artist(name, country, type, gender, artist.to_increase_id()));  //add into the array a new object 
        }

        //ArtistArray.forEach(st -> System.out.println("\nName : " + st.getName() + "\nCountry : " + st.getCountry() + "\nGender : " + st.getGender() + "\nType : " + st.getType()));
        return ArtistArray; //the method returns the array
    }

    public ArrayList<Artist> convert_json_object_based_on_country_to_artirst_and_put_into_arraylist(JSONObject jsonObject) {  //the method converts the json object to artist object and puts  the artist object into arraylist
        Artist artist = new Artist();
        JSONArray json_artists_list_ = (JSONArray) jsonObject.get("areas"); //the array named artists from the json object is being put into an arraylist 

        for (int i = 0; i < json_artists_list_.size(); i++) {

            JSONObject json_artist = (JSONObject) json_artists_list_.get(i);
            name = (String) json_artist.get("name");
            type = (String) json_artist.get("type");
            gender = ((String) json_artist.get("gender"));
            country = (String) json_artist.get("country");

            ArtistArray.add(new Artist(name, country, type, gender, artist.to_increase_id()));  //add into the array a new object 
        }

        // ArtistArray.forEach(st -> System.out.println("\n Name : " + st.getName() + "\n Country : " + st.getCountry() + "\n Gender : " + st.getGender() + "\nType : " + st.getType()));
        return ArtistArray; //the method returns the array
    }

    public ArrayList<Release> convert_json_object_to_release_and_put_into_arraylist(JSONObject jsonObject) {  //the method converts the object to artist object and puts it into the artist object into arraylist
        JSONArray json_artists_list_ = (JSONArray) jsonObject.get("releases");

        for (int i = 0; i < json_artists_list_.size(); i++) {
            JSONObject json_release = (JSONObject) json_artists_list_.get(i);
            title = ((String) json_release.get("title"));
            status = ((String) json_release.get("status"));
            releaseDate = (String) json_release.get("date");
            format = ((String) json_release.get("format"));
            country = ((String) json_release.get("country"));

            //the method puts the  Release object into arraylist
            ReleaseArray.add(new Release(title, status, country, releaseDate, format));
        }

        //ReleaseArray.forEach(st -> System.out.println("\n Title : " + st.getTitle() + "\n Status : " + st.getStatus() + "\n Country : " + st.getCountry() + "\n Release Date : " + st.getReleaseDate()+ "\n Format: " + st.getFormat()+ "\n Track Count: " + st.getTrackCount()));
        return ReleaseArray;                    //the method returns the array
    }

    public APIWrapper() {     //default constructor
    }

}
