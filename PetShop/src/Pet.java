/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 *
 * @author Alex J Davison
 */
public abstract class Pet {

    private String name;
    private boolean sold;
    private Date dob;
   

    public Pet(String n, boolean s, String d) {
        name = n;
        sold = s;
        dob = new Date(d);
    }

    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String s = "Name: " + name + "  Sold: " + sold + "  Date Of Birth: " + sdf.format(dob) + " Age: " + getAge();
        return s;
    }

    public String getName() {
        return name;
    }

    public boolean getSold() {
        return sold;
    }

    public String getDOB() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dob);
    }

    public int getAge() {
        Date now = new Date();
        long diff = now.getTime() - dob.getTime();
        long age = (diff / (1000L * 60 * 60 * 24 * 365));
        return (int) age;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public abstract void savePetText(FileWriter fw);

    public abstract void savePetSerial (DataOutputStream sw);

}
