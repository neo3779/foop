/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author dv003874
 */
public class TestCloneHashEquals {

    public static void main(String[] args) {

        Card c1 = new Card(Rank.ACE,Suit.CLUBS);
        Card c2 = new Card(Rank.ACE,Suit.CLUBS);
        Card c3 = null;


        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        System.out.println(c1.equals(c2));

        try{
        c3 = (Card)c1.clone();
        } catch (CloneNotSupportedException e) {System.out.println("Clone error");}

        System.out.println(c1.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c1.equals(c3));

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());

        Deck deck = new Deck();
        Deck deck2;

        Hand player1 = new Hand();
        Hand player2 = null;

        Card card1 = new Card(Rank.KING,Suit.DIAMONDS);
        Card card2 = new Card(Rank.SEVEN,Suit.DIAMONDS);
        Card card3 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card4 = new Card(Rank.TWO, Suit.SPADES);
        Card card5 = new Card(Rank.JAKE,Suit.CLUBS);

        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        player1.addCard(card4);
        player1.addCard(card5);

        try{
        player2 = (Hand)player1.clone();
        } catch (CloneNotSupportedException e) {System.out.println("Clone error");}

        System.out.println(player1.getCurrentHand());
        System.out.println(player2.getCurrentHand());
        System.out.println(player1.hashCode());
        System.out.println(player2.hashCode());

        deck2 = (Deck)deck.clone();

        System.out.println(deck2);
        

    }

}
