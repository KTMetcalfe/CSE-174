package Labs.Lab1;

// Kian Metcalfe
// CSE 174, Section D
// 8/20/20

// Practice with writing, saving, and compiling code.
// Plays a game of "Guess my number" with the user.

import java.util.Scanner; //Needed for user input

public class FirstProgram {

   public static void main(String[] args) {
      // Declare local variables
      float x = 4.0f;
      System.out.println(x);
      
      String first, last;
      int correctNumber, guess, guessCount;
      int triangleSize;
      Scanner keyboardReader = new Scanner(System.in);
      
      // Get user's first and last name
      System.out.print("What is your first and last name? ");
      first = keyboardReader.next();
      last = keyboardReader.next();
      
      // Display border and greeting
      drawBorder(50);
      welcome(first + " " + last);
      drawBorder(50);
      
      // Explain the rules
      gameRules(first);
      
      // Start the game with a random number
      correctNumber = (int)(1 + 100 * Math.random());
      guessCount = 0;
      
      // Get first guess
      guessCount++;
      System.out.print("Enter guess #" + guessCount + ": ");
      guess = keyboardReader.nextInt();
      
      // Loop until guess is correct
      while (guess != correctNumber) {
      
         // Higher or lower?
         if (guess < correctNumber) {
            System.out.println("Guess higher.");
         }
         else {
            System.out.println("Guess lower.");
         }
         
         // Get next guess
         guessCount++;
         System.out.print("Enter guess #" + guessCount + ": ");
         guess = keyboardReader.nextInt();
      } // end loop

      keyboardReader.close();
      
      // By the time we get here, the user has guessed the correct
      // number. Print the results
      System.out.println("Congratulations, " + first + ".");
      System.out.println("You got it in " + guessCount + " guesses.");
      
      if (guessCount < 7) {
         System.out.println("You are an excellent guesser. :)");
      }
      else {
         System.out.println("Try harder next time. :(");
      }
      
      // Display some art:
      System.out.println();
      System.out.println("And now, some stars to make you happy!");
      System.out.print("How many rows: ");
      
      triangleSize = keyboardReader.nextInt();
      for (int length = 1; length <= triangleSize; length++) {
         drawBorder(length);
      }
      
      System.out.println("Goodbye!");
      
   } // end main
   
   // Prints a personalized welcome message to the use
   public static void welcome(String name) {
      System.out.println("Welcome, " + name + ".");
      System.out.println("This is my first CSE 174 programming assignment.");
      System.out.println("Let's play \"Guess my number\"");
   } // end welcome
   
   // Explains the rules of the game
   public static void gameRules(String name) {
      System.out.println("Are you ready to play a game, " + name + "?");
      System.out.println("I will think of a number between 1 and 100.");
      System.out.println("Try to guess it in fewer than 7 tries.");
   } // end gameRules
   
   // Draws a border made of astrisks
   public static void drawBorder(int length) {
      for (int i = 0; i < length; i++) {
         System.out.print("*");
      }
      System.out.println(); // moves to next line
   } // end drawBorder
   
} // end class