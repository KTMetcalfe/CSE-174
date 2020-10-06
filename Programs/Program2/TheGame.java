// Kian Metcalfe
// CSE 174, Section D
// 10/4/20

// This program...

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class TheGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to CSE 174 Press Your Luck!");
        System.out.print("Enter the filename for this game round: ");
        String filename = input.next();
        File filepath = new File(filename);

        try {
            Scanner fileReader = new Scanner(filepath);
            int totalMoney = 0;
            boolean continueGuess = true;

            for (int round = 1; fileReader.hasNextInt() && continueGuess
                && round <= 15; round++) {
                int mysteryNumber = fileReader.nextInt();
                int roundMoney = (round * 100);
                System.out.printf("Round %d: $%d\n", round, roundMoney);

                for (int i = (16 - round); i >= 1; i--) {
                    System.out.printf("%d Guesses Remain - enter your guess: ",
                        i);
                    int guess = 0;
                    try {
                        guess = input.nextInt();
                    } catch (InputMismatchException e) {
                        guess = 0;
                        input.next();
                    }

                    if (guess == mysteryNumber) {
                        totalMoney += roundMoney;
                        if (fileReader.hasNextInt()) {
                            System.out.printf("Total Winnings So Far: $%d\n",
                                totalMoney);
                        }
                        break;
                    } else {
                        System.out.print("Incorrect; the mystery number is ");
                        if (guess > mysteryNumber) {
                            System.out.println("lower.");
                        } else {
                            System.out.println("higher.");
                        }

                        if (i == 1) {
                            System.out.printf("The mystery number was %d\n",
                                mysteryNumber);
                            continueGuess = false;
                            totalMoney = 0;
                        }
                    }
                }

                if (fileReader.hasNextInt() && continueGuess) {
                    System.out.print("Do you want to continue (y/n)?: ");
                    if (!input.next().equals("y")) {
                        continueGuess = false;
                    }
                }
            }
            System.out.printf("Game over! Total Winnings: $%d", totalMoney);

            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        input.close();
    }
}
