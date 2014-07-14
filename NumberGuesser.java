/* Class:	Number Guesser
 * Name:		Rick Larsen
 * Date:		9/29/2013 
 * Purpose:	Computer thinks of a random number between 1-100. Player attempts to guess
 *          and computer tells if they are high or low. Lowest score in number of guesses
 *          is tracked in a Scoreboard object
 */

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class NumberGuesser
{

	public static void main(String[] args) throws IOException
   {
      // Scoreboard object created to track score
      Scoreboard scores = new Scoreboard();

      // Player Instructions
      System.out.println("I'm thinking of a number between 1 and 100");
      System.out.println("Try to guess it, if you dare!");
      newGame(scores);
   }
      // New Game
      public static void newGame(Scoreboard scores)
      {
      
      // Scanner object to accept input
      Scanner keyboard = new Scanner(System.in);
      
      // Random number object
      Random randomNumbers = new Random();
      
      // Variable declarations
      String tooHigh = "Too high. Guess lower.";
      String tooLow = "Too low. Guess higher.";
      int guess = 0; // reset guess for new game
      int numberToGuess = randomNumbers.nextInt(100) + 1;
      int currentScore = 0; // reset currentScore for new game

      try // validate user input
      {
           while (guess != numberToGuess) // loops until player guesses correctly
           {
           // player notified if guess is out of bounds
           guess = keyboard.nextInt();
           if (guess < 1 || guess > 100)
            {
               currentScore = scores.getScore() + 1;
               scores.setScore(currentScore);
               System.out.println("The number is between 1 and 100");
            }
            // guess too low
            else if(guess < numberToGuess)
            {
               currentScore = scores.getScore() + 1;
               scores.setScore(currentScore);
               System.out.println(tooLow);
            }
            // guess too high
            else if(guess > numberToGuess)
            {
               currentScore = scores.getScore() + 1;
               scores.setScore(currentScore);
               System.out.println(tooHigh);
            }
           }
           currentScore = scores.getScore();
           scores.setScore(currentScore);
           scores.checkBestScore(currentScore);
           System.out.println(scores.toString());
           scores.setScore(0);
           System.out.println("I'm thinking of another number. Try again?");
           System.out.println("Enter a number to begin:");
           newGame(scores);
      }
      catch(Exception exc)
      {
            currentScore = scores.getScore() + 1;
            System.out.println("Enter a valid number.");
            guess = keyboard.nextInt();
      }   
   }
}
