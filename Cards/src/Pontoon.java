/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex J Davison
 */
import java.util.*;

public class Pontoon {
    	public static void main(String[]args)
	{

		Scanner kybd = new Scanner(System.in);
		String ans;

			do
			{
				// play a hand of game
				// ask user if finished


				playHand();

				System.out.println("Have you finished playing?");
				ans = kybd.next();

			} while ( ans.equals("no") );
        }

        public static void playHand()
	{

	    System.out.println("Starting a new hand of the game");

            Deck deck = new Deck();
            deck.shuffle();

            Hand player = new Hand();
            Hand computer = new Hand();


            player.addCard(deck.getCard(1));
            computer.addCard(deck.getCard(1));
            player.addCard(deck.getCard(1));
            computer.addCard(deck.getCard(1));
            System.out.println("Player's hand: ");
            System.out.println(player.getCurrentHand());
            System.out.println(player.getCurrentScore());
            System.out.println("Computer's hand: ");
            System.out.println(computer.getCurrentHand());
            System.out.println(computer.getCurrentScore());

            Scanner kybd = new Scanner(System.in);

            if ( computer.getCurrentScore() > 21 )
            {
                System.out.println("Sorry computer is bust!");
		// check and display the winner
	    	checkWinner(computer.getCurrentScore(),player.getCurrentScore());

            }
            else if ( player.getCurrentScore() > 21 )
            {
                System.out.println("Sorry your bust!");
                // check and display the winner
                checkWinner(computer.getCurrentScore(),player.getCurrentScore());

            }
            else
            {


                // ask if card required
	     	System.out.println("Would you like another card?");
	     	String reply = kybd.next();
	     	while ( reply.equals("yes"))
	     	{
                    player.addCard(deck.getCard(1));
                    System.out.println("Player's hand: ");
                    System.out.println(player.getCurrentHand());
                    System.out.println(player.getCurrentScore());

                    if ( player.getCurrentScore() > 21 )
                    {
                        checkWinner(computer.getCurrentScore(),player.getCurrentScore());
                        reply = "no";
                    }
                    else
                    {
                        System.out.println("Would you like another card?");
	           	reply = kybd.next();
                    }
                }

                if (player.getCurrentScore() <= 21 )
		{
                    while ( computer.getCurrentScore() < 14 )
                    {
                        // deal a card to the computer and generate players score
                        System.out.print("Comptuer has another card.");
                        computer.addCard(deck.getCard(1));
                        System.out.println("Computer's hand: ");
                        System.out.println(computer.getCurrentHand());
                        System.out.println(computer.getCurrentScore());
                    }
                }
                checkWinner(computer.getCurrentScore(),player.getCurrentScore());
            }
        }
        

        public static void checkWinner(int computerScore, int playerScore)
	{

            if (computerScore > 21 && playerScore > 21)
            {
		System.out.println("Computer/Player both lose.");
            }
            else if (computerScore > 21)
            {
                System.out.println("Congratulations player wins");
            }
            else if (playerScore > 21)
            {
            	System.out.println("Sorry player lose, computer wins");
            }
            else if(playerScore == computerScore)
            {
                System.out.println("We player and computer wins!!!");
            }
            else if (playerScore > computerScore)
            {
                System.out.println("Congratulations player wins");
            }
            else
            {
                System.out.println("Sorry player lose, computer win");
            }
	}
}
