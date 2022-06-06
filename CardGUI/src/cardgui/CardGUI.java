/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgui;

/**
 *
 * @author Alex J Davison
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CardGUI extends JFrame {

    private static DisplayableCard[] deck = new DisplayableCard[52];

    public CardGUI(String sTitle) {

        super(sTitle);
        setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setVisible(true);

    }



        public static void main(String args[]) {
        new CardGUI("CardGUI");
        }

        public void loadImages (){
            int xPos = 0;
            int yPos = 0;

            for(int i = 0; i<52;i++)
            {
                ImageIcon img = new ImageIcon("\\images\\classic-cards\\" + i + ".png");
                DisplayableCard card = new DisplayableCard(img);
                card.moveTo(xPos, yPos);
                deck[i] = card;
                xPos +=5;
                yPos +=4;
            }
        }

}
