/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author dv003874
 */
public class TestCard {

    public static void main(String[] args) {

        ArrayList<Card> deck = new ArrayList<Card>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        System.out.println(deck);

    }
}
