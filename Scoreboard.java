/* Class:	Scoreboard
 * Name:		Rick Larsen
 * Date:		9/29/2013 
 * Purpose:	Define Scoreboard object to track best scores
 */

public class Scoreboard
{
   // Properties
   private int score;
   private static int bestScore = 100;
   
   // accessor method for current score
   public int getScore()
   {
      return score;   
   }
   
   // mutator method for current score
   public void setScore(int newScore)
   {
      score = newScore;
   }
   
   // accessor method for best score
   public static int getBestScore()
   {
      return bestScore;
   }
   
   // mutator method for best score
   
   public static void checkBestScore(int currScore)
   {
      if (currScore < bestScore)
      {
         bestScore = currScore;
      }
      
   }
   public String toString()
   {
      String scoreDisplay = "You guessed in " + String.valueOf(score) + " tries. Best score is " + String.valueOf(bestScore) + ".";
      return scoreDisplay;
   }
}