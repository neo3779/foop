/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author dv003874
 */
public class Cat extends Pet {

    private Boolean landsOnFeet ;

    public Cat (String n, boolean s, String d, Boolean l)
    {
        super(n, s, d);
        landsOnFeet = l;
    }

    public Boolean  getLandsOnFeet()
    {
        return landsOnFeet;
    }

    public String toString() {

        String s = super.toString() + " Lands On Feet: " + landsOnFeet;
        return s;
    }

    public void savePetText(FileWriter fw){
    try{
    fw.write("Cat " + super.getName()+ " " + super.getSold()+ " " + super.getDOB()+ " " + landsOnFeet + "\r\n");
    }catch(IOException e) { }
    }

    public void savePetSerial (DataOutputStream sw){
       try{
       sw.writeUTF("Cat");
       sw.writeUTF(super.getName());
       sw.writeBoolean(super.getSold());
       sw.writeUTF(super.getDOB());
       sw.writeBoolean(landsOnFeet);
       }catch(IOException e) { }
    }

}


