/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author dv003874
 */
public class Dog extends Pet {

    private String breed ;

    public Dog (String n, boolean s, String d, String b)
    {
        super(n, s, d);
        breed = b;
    }

    public String getBreed()
    {
        return breed;
    }

    public String toString() {

        String s = super.toString() + " Breed:" + breed;
        return s;
    }
    public void savePetText(FileWriter fw){
    try{
    fw.write("Dog " + super.getName()+ " " + super.getSold()+ " " + super.getDOB()+ " " + breed + "\r\n");
    }catch(IOException e) { }
    }
    public void savePetSerial (DataOutputStream sw){
       try{
       sw.writeUTF("Dog");
       sw.writeUTF(super.getName());
       sw.writeBoolean(super.getSold());
       sw.writeUTF(super.getDOB());
       sw.writeUTF( breed );
       }catch(IOException e) { }
    }

}
