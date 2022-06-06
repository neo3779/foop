/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author DV003874
 */
public class PetShopGUI extends JFrame{

    private int numlbl, numbtn;
    private String labels[];
    private JLabel detaillbl[];
    private String btnlabels[];
    private JButton buttons[];
    private JTextField textFeilds[];
    private PetShop thePetShop = new PetShop("Stafford Octagons");
    private Cat c1 = new Cat("Dave",false, "12/01/1990",true);
    private Dog d1 = new Dog("Murphy",true, "08/12/2006","Lab");
    private Hamster h1 = new Hamster("Fluffy",false,"09/25/2009",29.0);
    private Parrot p1 = new Parrot("Sam",false,"12/12/2006","Red");
    private boolean addPet = false;
    private Container contentPane;

    public PetShopGUI(String sTitle) {

        super(sTitle);
        
        contentPane = getContentPane();
        System.out.println("Labels " + numlbl + " buttons " + numbtn);
        contentPane.setLayout(new GridLayout(numlbl + (numbtn / 2), 2));

        numlbl = 6;
        numbtn = 6;

        labels = new String[numlbl];
        detaillbl = new JLabel[numlbl];
        textFeilds = new JTextField[numlbl];
        btnlabels = new String[numbtn];
        buttons = new JButton[numbtn];
        
        labels[0] = "Type:";
        labels[1] = "Name:";
        labels[2] = "Sold:";
        labels[3] = "DOB:";
        labels[4] = "Age:";
        labels[5] = ":";


        
        btnlabels[0] = "Previous";
        btnlabels[1] = "Next";
        btnlabels[2] = "Add New Pet";
        btnlabels[3] = "Find Pet";
        btnlabels[4] = "Delete Pet";
        btnlabels[5] = "Exit";

        for (int i = 0; i < numlbl; i++) {
            detaillbl[i] = new JLabel(labels[i]);
            textFeilds[i] = new JTextField(10);
            contentPane.add(detaillbl[i]);
            contentPane.add(textFeilds[i]);
            textFeilds[i].setEditable(false);
        }

        for (int i = 0; i < numbtn; i++) {
            JButton button = new JButton(btnlabels[i]);
            buttons[i] = button;
            contentPane.add(buttons[i]);
        }

        buttons[0].addActionListener(new ActionListener() {public void actionPerformed (ActionEvent e){
            if(addPet)
            {
                addPet();
            }else
            {
                thePetShop.nextPet();
                updateDetails();
            }
        }});

        buttons[1].addActionListener(new ActionListener() {public void actionPerformed (ActionEvent e){
            if(addPet)
            {
                restView();
            }else{
                thePetShop.previousPet();
                updateDetails();
            }
        }});

        buttons[2].addActionListener(new ActionListener() {public void actionPerformed (ActionEvent e){
            addPet=true;
            addPetView();
        }});

        buttons[3].addActionListener(new ActionListener() {public void actionPerformed (ActionEvent e){

            String response = JOptionPane.showInputDialog(null,"Enter the name of the pet","Find pet.",
            JOptionPane.QUESTION_MESSAGE);
            if(response != null){
                Pet p = thePetShop.findPet(response);
                updateDetails(p);
            }
            else
            {
                updateDetails();
            }

        }});

        buttons[4].addActionListener(new ActionListener() {public void actionPerformed (ActionEvent e){

            thePetShop.deletePet(thePetShop.getCurrentPet().getName());
            thePetShop.nextPet();
            updateDetails();

        }});

        buttons[5].addActionListener(new ActionListener() {public void actionPerformed (ActionEvent e){

                System.exit(0);

        }});

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);

        // add a few pets
        //thePetShop.addPet(c1);
        //thePetShop.addPet(d1);
        //thePetShop.addPet(h1);
        //thePetShop.addPet(p1);

        updateDetails();

        this.setVisible(true);

    }

    public static void main(String args[]) {
        new PetShopGUI("Pet Shop Sample Frame");

    }

    public void updateDetails() {
        
        if (thePetShop.getCurrentPet()!= null)
        {
            textFeilds[0].setText(thePetShop.getCurrentPet().getClass().getName());
            textFeilds[1].setText(thePetShop.getCurrentPet().getName());
            String soldString = thePetShop.getCurrentPet().getSold() ? "Sold" : "For sale";
            textFeilds[2].setText(soldString);
            textFeilds[3].setText(thePetShop.getCurrentPet().getDOB());
            textFeilds[4].setText(thePetShop.getCurrentPet().getAge()+"");
            lastTextBox();
        }




    }

    public void updateDetails(Pet p) {
        textFeilds[0].setText(p.getClass().getName());
        textFeilds[1].setText(p.getName());
        String soldString = p.getSold() ? "Sold" : "For sale";
        textFeilds[2].setText(soldString);
        textFeilds[3].setText(p.getDOB());
        textFeilds[4].setText(p.getAge()+"");
        lastTextBox();

    }

    public void lastTextBox(){
        if (thePetShop.getCurrentPet() instanceof Cat)
        {
            detaillbl[5].setText("Lands on feet:");
            Cat c2 = (Cat)thePetShop.getCurrentPet();
            String landsString = c2.getLandsOnFeet() ? "Yes" : "No";
            textFeilds[5].setText(landsString);
        }
        else if (thePetShop.getCurrentPet() instanceof Dog)
        {
            detaillbl[5].setText("Breed:");
            Dog d2 = (Dog)thePetShop.getCurrentPet();
            textFeilds[5].setText(d2.getBreed());
        }else if (thePetShop.getCurrentPet() instanceof Hamster)
        {
            detaillbl[5].setText("Weight:");
            Hamster h2 = (Hamster)thePetShop.getCurrentPet();
            textFeilds[5].setText(h2.getWeight()+"");
        }else if (thePetShop.getCurrentPet() instanceof Parrot)
        {
            detaillbl[5].setText("Colour:");
            Parrot p2 = (Parrot)thePetShop.getCurrentPet();
            textFeilds[5].setText(p2.getColour());
        }
    }

    public void addPetView (){
        for (int i = 2; i < numbtn; i++) {
            contentPane.remove(buttons[i]);
            buttons[i].setVisible(false);
        }


        contentPane.setLayout(new GridLayout(numlbl + (2 / 2), 2));

        for (int i = 0; i < numlbl; i++) {
            textFeilds[i].setText(null);
            textFeilds[i].setEditable(true);
        }

        textFeilds[4].setEditable(false);

        detaillbl[5].setText("Colour,Lands,Weight,Breed:");
        this.setSize(350, 400);
        buttons[0].setText("Add");
        buttons[1].setText("Canncel");

    }

    public void restView(){

        addPet = false;

        for (int i = 0; i < numlbl; i++) {
            textFeilds[i].setEditable(false);
        }
        for (int i = 0; i < numbtn; i++) {
            buttons[i].setText(btnlabels[i]);
            buttons[i].setVisible(true);
        }
        
        for (int i = 2; i < numbtn; i++) {
            contentPane.add(buttons[i]);
        }

        contentPane.setLayout(new GridLayout(numlbl + (numbtn / 2), 2));
        this.setSize(300, 400);
        updateDetails();
    }

    public void addPet(){
        String cat = "cat";
        String hamster = "hamster";
        String dog = "dog";
        String parrot = "parrot";


        if(cat.compareToIgnoreCase(textFeilds[0].getText()) ==0)
        {
            Cat c3 = new Cat(textFeilds[1].getText(),false,textFeilds[3].getText(),true);
            thePetShop.addPet(c3);
            JOptionPane.showMessageDialog(null, "A cat has been added.");
        }
        else if(hamster.compareToIgnoreCase(textFeilds[0].getText()) ==0)
        {
            Hamster h3 = new Hamster(textFeilds[1].getText(),false,textFeilds[3].getText(),0.0);
            thePetShop.addPet(h3);
            JOptionPane.showMessageDialog(null, "A hamster has been added.");
        }else if(dog.compareToIgnoreCase(textFeilds[0].getText()) ==0)
        {
            Dog d3 = new Dog(textFeilds[1].getText(),false,textFeilds[3].getText(),textFeilds[5].getText());
            thePetShop.addPet(d3);
            JOptionPane.showMessageDialog(null, "A dog has been added.");
        }else if(parrot.compareToIgnoreCase(textFeilds[0].getText()) ==0)
        {
            Parrot p3 = new Parrot(textFeilds[1].getText(),false,textFeilds[3].getText(),textFeilds[5].getText());
            thePetShop.addPet(p3);
            JOptionPane.showMessageDialog(null, "A parrot has been added.");
            
        }

        restView();


    }

}
