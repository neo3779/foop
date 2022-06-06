/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Alex Davison
 */
public class TestCollections {

    public static void main(String[] args) {

        Deck deck = new Deck();

        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
        deck.sort();
        System.out.println(deck);

        Card card1 = new Card(Rank.KING,Suit.DIAMONDS);
        Card card2 = new Card(Rank.SEVEN,Suit.DIAMONDS);
        Card card3 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card4 = new Card(Rank.TWO, Suit.SPADES);
        Card card5 = new Card(Rank.JAKE,Suit.CLUBS);

        Hand player1 = new Hand();

        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        player1.addCard(card4);
        player1.addCard(card5);

        player1.sort();
        
        System.out.println(player1);

        System.out.println(deck.search(card5));



    }



}
