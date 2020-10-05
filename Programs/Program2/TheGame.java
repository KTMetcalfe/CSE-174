// Kian Metcalfe
// CSE 174, Section D
// 10/4/20

// This program...

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TheGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Introduction();
        File filename = new File("/Users/kianmetcalfe/Desktop/CSE-174/Programs/Program2/" + input.next());

        GuessSequence(filename);
        input.close();
    }

    public static void Introduction() {
        System.out.println("Welcome to CSE 174 Press Your Luck!");
        System.out.print("Enter the filename for this game round: ");
    }

    public static void GuessSequence(File filename) {
        Scanner guessReader = new Scanner(System.in);
        try {
            Scanner fileReader = new Scanner(filename);
            int totalMoney = 0;
            boolean continueGuess = true;

            for(int round = 1; fileReader.hasNextInt() && continueGuess && round <= 15; round++) {
                int mysteryNumber = fileReader.nextInt();
                int roundMoney = (round * 100);
                System.out.printf("Round %d: $%d\n", round, roundMoney);

                for(int i = (16 - round); i >= 1; i--) {
                    System.out.printf("%d guesses remain - enter your guess: ", i);
                    int guess = guessReader.nextInt();

                    if (guess == mysteryNumber) {
                        System.out.printf("Total Winnings So Far: $%d\n", totalMoney += roundMoney);
                        break;
                    } else {
                        System.out.print("Incorrect; the mystery number is ");
                        if (guess < mysteryNumber) {
                            System.out.println("higher.");
                        } else {
                            System.out.println("lower.");
                        }

                        if (i == 1) {
                            System.out.printf("The mystery number was %d\n", mysteryNumber);
                            continueGuess = false;
                        }
                    }
                }

                if (fileReader.hasNextInt() && continueGuess) {
                    System.out.println("Do you want to continue (y/n)?: ");
                    if (!guessReader.next().equals("y")) {
                        continueGuess = false;
                    }
                }
            }
            System.out.printf("Game over! Total Winnings: $%d", totalMoney);

            fileReader.close();
        } catch(FileNotFoundException e) {
            System.out.printf("%s (The system cannot find the file specified)\n", filename);
        }
        guessReader.close();
    }
}
