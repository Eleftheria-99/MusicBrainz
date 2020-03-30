/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import basics.*;
import db.*;
import tests.*;

/**
 *
 * @author it21735/it21754/it217130
 *
 */
public class Call_API_Methods {

    public void call_the_api() {
        APIWrapper http = new APIWrapper();
        http.searchForNameGroup("One-Direction");
        http.searchForNameGroup("Fred");

        http.searchForArtistName("jennifer");

        http.searchForCountry("FR");
        http.search_for_Release("Schneider");
    }
}
