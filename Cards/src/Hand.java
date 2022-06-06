/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Alex J Davison
 */
public class Hand implements Cloneable{

    // a class to represent a hand of cards
    private ArrayList<Card> theCards;

    public Hand() {
        theCards = new ArrayList<Card>();
    }


    public void addCard(Card aCard) {
            theCards.add(aCard);
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < theCards.size(); ++i) {
            s += "\n" + theCards.get(i);
        }
        return s;
    }

    public String getCurrentHand() {
        String s = "";
        for (Card theCard : theCards) {
            s = s + theCard;
        }
        return s;
    }

    public int getCurrentScore() {
        int s = 0;
        for (Card theCard : theCards) {
            s = s + theCard.getRank().getNumScore();
        }

        return s;
    }

   public Object clone() throws CloneNotSupportedException
   {
        Hand result = (Hand)super.clone();
        return result;
   }

   public void sort()
   {
    Collections.sort(theCards);
   }
}
