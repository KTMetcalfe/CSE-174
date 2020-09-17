// Kian Metcalfe
// CSE 174, Section D
// 9/3/20

// This program takes in a 3-digit integer and prints out
// various calculated results

import java.util.Scanner;

public class NumberSplitter {
    public static void main(String[] args) {
        // Creates scanner and recieves theNumber
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive 3-digit integer: ");
        int theNumber = input.nextInt();
        input.close();

        // Calculates the individual digits from theNumber
        int digitOne = theNumber / 100;
        int digitTwo = (theNumber % 100) / 10;
        int digitThree = theNumber % 10;

        int digitSum = digitOne + digitTwo + digitThree;
        int digitReversed = (digitThree * 100) + (digitTwo * 10) + digitOne;

        // Prints the calculated results
        System.out.printf("You entered: %6d%n", theNumber);
        System.out.printf("Digit sum: %8d%n", digitSum);
        System.out.printf("Reversed: %9d%n", digitReversed);
        System.out.printf("num + reverse: %4d%n", (theNumber + digitReversed));
    }
}
