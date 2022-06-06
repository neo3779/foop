package cardgui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author dv003874
 */
public class Compare implements Comparator<Card> {

    public int compare (Card c1, Card c2){

        int comp = c1.getSuit().compareTo(c2.getSuit());

                if(comp != 0)
                {
                    return comp;
                }
                else
                {
                    return c1.getRank().compareTo(c2.getRank());
                }
}
}

