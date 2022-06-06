/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author dv003874
 */
public class Parrot extends Pet {

        private String colour ;

    public Parrot (String n, boolean s, String d, String c)
    {
        super(n, s, d);
        colour = c;
    }

    public String getColour()
    {
        return colour;
    }

    public String toString() {

        String s = super.toString() + " Colour:" + colour;
        return s;
    }

    public void savePetText(FileWriter fw){
    try{
    fw.write("Parrot," + super.getName()+ " " + super.getSold()+ " " + super.getDOB()+ " " + colour + "\r\n");
    }catch(IOException e) { }
    }

    public void savePetSerial (DataOutputStream sw){
       try{
       sw.writeUTF("Parrot");
       sw.writeUTF(super.getName());
       sw.writeBoolean(super.getSold());
       sw.writeUTF(super.getDOB());
       sw.writeUTF(colour );
       }catch(IOException e) { }
    }

}
