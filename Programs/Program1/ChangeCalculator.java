package Programs.Program1;

// Kian Metcalfe
// CSE 174, Section D
// 9/4/20

// This program takes in amounts of different coins and reduces the
// total amount based on their combined value

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ChangeCalculator {
    public static void main(String[] args) throws FileNotFoundException {
        // Creates scanner and takes in file names
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the name of the input file: ");
        File fileInput = new File("/Users/kianmetcalfe/desktop/CSE-174/Programs/Program1/" + input.next());
        System.out.printf("Enter the name of the output (csv) file: ");
        File fileOutput = new File("/Users/kianmetcalfe/desktop/CSE-174/Programs/Program1/" + input.next());
        input.close();

        // Creates scanner to pull out data from input file
        Scanner fileReader = new Scanner(fileInput);
        int pennies1 = fileReader.nextInt();
        int nickels1 = fileReader.nextInt();
        int dimes1 = fileReader.nextInt();
        int quarters1 = fileReader.nextInt();
        int coinCount1 = pennies1 + nickels1 + dimes1 + quarters1;
        int totalPennies = pennies1 + (5 * nickels1)
            + (10 * dimes1) +  (25 * quarters1);
        fileReader.close();

        // Divides total coins into smallest groups
        int pennies2 = totalPennies % 5;
        int dimes2 = (totalPennies % 25) / 10;
        int quarters2 = totalPennies / 25;
        int nickels2 = ((totalPennies % 25) - (10 * dimes2) - pennies2) / 5;
        int coinCount2 = pennies2 + nickels2 + dimes2 + quarters2;

        // Prints out a table displaying the calculated results
        System.out.printf("---------------------------------%n");
        System.out.printf("          |  original|     final|%n");
        System.out.printf("   pennies|%10d|%10d|%n", pennies1, pennies2);
        System.out.printf("   nickels|%10d|%10d|%n", nickels1, nickels2);
        System.out.printf("     dimes|%10d|%10d|%n", dimes1, dimes2);
        System.out.printf("  quarters|%10d|%10d|%n", quarters1, quarters2);
        System.out.printf("coin count|%10d|%10d|%n", coinCount1, coinCount2);
        System.out.printf("---------------------------------%n");
        System.out.printf("total = $%.2f%n", (totalPennies / 100.0));

        // Prints the calculated results to output file
        PrintWriter fileWriter = new PrintWriter(fileOutput);
        fileWriter.printf(",pennies,nickels,dimes,quarters,coin count%n");
        fileWriter.printf("original,%d,%d,%d,%d,%d%n",
            pennies1, nickels1, dimes1, quarters1, coinCount1);
        fileWriter.printf("final,%d,%d,%d,%d,%d%n",
            pennies1, nickels2, dimes2, quarters2, coinCount2);
        fileWriter.printf("total,$%.2f%n", (totalPennies / 100.0));
        fileWriter.close();
    }
}
