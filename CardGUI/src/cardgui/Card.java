package cardgui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex J Davison
 */
public class Card implements Cloneable, Comparable<Card>{

    private Rank rank;
    private Suit suit;

    public Card(Rank theRank) {
        this(theRank, Suit.HEARTS);
    }

    public Card(Rank theRank, Suit theSuit) {
        rank = theRank;
        suit = theSuit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
    public String toString() {
        return (rank + " of " + suit + "\n");
    }

    public int hashCode(){
        int hash = rank.hashCode() + suit.hashCode();
        return hash;
    }
    public boolean equals(Object obj)
    {
        if (rank.compareTo(((Card)obj).rank) == 1 && suit.compareTo(((Card)obj).suit) == 1)
        {
            return true;
        }else{
            return false;
        }
        
    }

   public Object clone() throws CloneNotSupportedException
   {
        Card result = (Card)super.clone();
        return result;
   }


       public int compareTo(Card c)
    {
        if (rank.getNumScore() < c.getRank().getNumScore()){

            return -1;
        }
              
        else  if (rank.getNumScore() > c.getRank().getNumScore())
        {
            return 1;
        }
        return 0;

    }


       }


