package cardgui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.util.Collections.*;

/**
 *
 * @author dv003874
 */
public class Deck implements Cloneable{

    private List<Card> cards = new ArrayList<Card>();



    public Deck (){

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
}

 public Object clone()
   {
       Deck deck2 = new Deck ();
       try{
       
       for (int i=0 ; i < cards.size(); i++)
       {
           deck2.cards.add((Card)cards.get(i).clone()); 
       }
       } catch (CloneNotSupportedException e) {System.out.println("Clone error");}
       return deck2;
 }

 public void shuffle()
 {
     Collections.shuffle(cards);
 }

 public void sort()
 {
    Collections.sort(cards, new Compare());
 }

public String toString()
{
    String s = "";

    for(Card c : cards){
        s+= c.toString();
    }
    return s;
    
}

       public int search(Card c){
       sort();
       return Collections.binarySearch(cards, c);

       }

}
