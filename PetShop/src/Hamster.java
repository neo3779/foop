/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author dv003874
 */
public class Hamster extends Pet {

        private double weight ;

    public Hamster (String n, boolean s, String d, double w)
    {
        super(n, s, d);
        weight = w;
    }

    public double getWeight()
    {
        return weight;
    }

    public String toString() {

        String s = super.toString() + " Weight:" + weight + "g";
        return s;
    }
    public void savePetText(FileWriter fw){
    try{
    fw.write("Hamster " + super.getName()+ " " + super.getSold()+ " " + super.getDOB()+ " " + weight + "\r\n");
    }catch(IOException e) { }
    }

    public void savePetSerial (DataOutputStream sw){
       try{
       sw.writeUTF("Hamster");
       sw.writeUTF(super.getName());
       sw.writeBoolean(super.getSold());
       sw.writeUTF(super.getDOB());
       sw.writeDouble(weight);
       }catch(IOException e) { }
    }

}
