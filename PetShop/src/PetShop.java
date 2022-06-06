/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;
import java.io.Serializable;



/**
 *
 * @author Alex J Davison
 */
public class PetShop implements Serializable {

    private ArrayList<Pet> thePets;
    private ListIterator <Pet> theIterator;
    private String thePetShopName;
    private Pet currentPet;

    public PetShop(String name) {

        // call the read from text method
        thePetShopName = name;
        thePets = new ArrayList<Pet>();
        theIterator = thePets.listIterator();
    }

    public Pet getCurrentPet() {
        return currentPet;
    }

    public void nextPet() {
        if (theIterator.hasNext())
            currentPet  = theIterator.next();
    }

    public void previousPet() {
        if (theIterator.hasPrevious())
	currentPet = theIterator.previous();

    }

    public boolean addPet(Pet newPet) {
        theIterator.add(newPet);
        return true;
    }

    public void outputPetShopPets() {
        System.out.println("Pet Shop Name: " + thePetShopName);
        //output each player in turn
        System.out.println("The pets:");
        for (Pet nextPet : thePets) {
            System.out.println(nextPet.toString());
        }
    }

    public Pet findPet(String petName) {
        for (Pet p : thePets) {
            if (p.getName().equalsIgnoreCase(petName)) {
                currentPet = thePets.get(thePets.indexOf(p));
                return p;
            }
        }
        return null;
    }

    public boolean deletePet(String name) {
        Pet p = findPet(name);
        if (p != null) {
            theIterator.remove();
            return true;
        }
        return false;
    }

    public void saveCurrentPetText(){
        if(currentPet !=null){

        try {
        File currentPetFile = new File("currentPetFile.txt");
        FileWriter fw = new FileWriter(currentPetFile,true);
        currentPet.savePetText(fw);
        fw.flush(); // flush before closing
        fw.close(); // close file when done
        }catch(IOException e) { }

        }
    }

    public String addTextFile (String filename){

        Scanner input = null;
        String type = null;
        String name = null;
        Boolean sold = null;
        String dob = null;

        try {
            input = new Scanner(new File(filename));
//            input.useDelimiter(",");
            while (input.hasNext()){
                type = input.next();
                if(type.equalsIgnoreCase("Cat"))
                {
                    name = input.next();
                    sold = input.nextBoolean();
                    dob = input.next();
                    Boolean feet = input.nextBoolean();
                    Cat c1 = new Cat(name,sold,dob,feet);
                    this.addPet(c1);
                }else if(type.equalsIgnoreCase("Dog"))
                {
                    name = input.next();
                    sold = input.nextBoolean();
                    dob = input.next();
                    String breed= input.next();
                    Dog d1 = new Dog(name,sold,dob,breed);
                    this.addPet(d1);
                }else if(type.equalsIgnoreCase("Hamster"))
                {
                    name = input.next();
                    sold = input.nextBoolean();
                    dob = input.next();
                    double weight = input.nextDouble();
                    Hamster h1 = new Hamster(name,sold,dob,weight);
                    this.addPet(h1);
                }else if(type.equalsIgnoreCase("Parrot"))
                {
                    name = input.next();
                    sold = input.nextBoolean();
                    dob = input.next();
                    String colour = input.next();
                    Parrot p1 = new Parrot(name,sold,dob,colour);
                    this.addPet(p1);
                }
                else
                {
                    System.out.println("Don't know what it is");
                }
              
            }
            return "Pet(s) from file "+ filename +" has been added to the petshop.";
        }
        catch (FileNotFoundException ex)  {
            return "File does not exist: " + ex.getMessage();}
        catch (Exception ex)  {
            return "Error reading data " + ex.toString();}
        finally  {
            if (input != null)
                input.close();
        }

    }

    public void serialOutFile() {
        try{
            DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"));
        for (Pet nextPet : thePets) {
            nextPet.savePetSerial(output);
        }
         output.close();

        }catch(IOException e) { }
    }

    public void serialInFile(){
        boolean EOF = false;
        String type = null;
        String name = null;
        Boolean sold = null;
        String dob = null;

        try{
            DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"));

            while (!EOF)
            {

                type = input.readUTF();
                System.out.println(type);
                if(type.equalsIgnoreCase("Cat"))
                {
                    name = input.readUTF();
                    sold = input.readBoolean();
                    dob = input.readUTF();
                    Boolean feet = input.readBoolean();
                    Cat c1 = new Cat(name,sold,dob,feet);
                    this.addPet(c1);
                }else if(type.equalsIgnoreCase("Dog"))
                {
                    name = input.readUTF();
                    sold = input.readBoolean();
                    dob = input.readUTF();
                    String breed= input.readUTF();
                    Dog d1 = new Dog(name,sold,dob,breed);
                    this.addPet(d1);
                }else if(type.equalsIgnoreCase("Hamster"))
                {
                    name = input.readUTF();
                    sold = input.readBoolean();
                    dob = input.readUTF();
                    double weight = input.readDouble();
                    Hamster h1 = new Hamster(name,sold,dob,weight);
                    this.addPet(h1);
                }else if(type.equalsIgnoreCase("Parrot"))
                {
                    name = input.readUTF();
                    sold = input.readBoolean();
                    dob = input.readUTF();;
                    String colour = input.readUTF();
                    Parrot p1 = new Parrot(name,sold,dob,colour);
                    this.addPet(p1);
                }
                else
                {
                    System.out.println("Don't know what it is");
                }
        }

        }catch(IOException e) {
        EOF = true;
        }
    }

}
