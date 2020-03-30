/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import basics.*;
import files.*;
import tests.*;

/**
 *
 * @author it21735/it21754/it217130
 */
public class CallTheMethods {

    public void callingMethods() {

        Artist w = new Artist();
        w.Aliases.add("Lady Lee");
        w.Aliases.add("PopQueen");
        w.Aliases.add("Lee");

        w.Tags.add("nice");
        w.Tags.add("sweet");
        w.Tags.add("unique style");

        Artist c = new Artist();
        c.setName("Lana");

        Compilation m = new Compilation();

        int id = c.to_increase_id();
        Person n = new Person("Female", c.stringToDAte("13/05/1995"), c.stringToDAte("-"), "Maria", "Greece", "Athens,Patra", id);

        int id1 = c.to_increase_id();
        Group z = new Group(c.stringToDAte("03-07-2002"), c.stringToDAte("-"), "Two Directions", "UK", "Kent,London,Sussex", id1);

        m.add_element_to_list_Artists(n);
        m.add_element_to_list_Artists(z);

        Person y = new Person();
        y.setGender("Female");
        //System.out.println(y.getGender());

        Album b = new Album();
        b.add_element_to_list_Album("7 rings", "official", "English", "09-08-2019", "cd", 10);

        Group g = new Group();
        g.Members.add("Group:One Direction: anna, eva, maria");

        //System.out.println(w.Aliases.get(2));
    }

}
