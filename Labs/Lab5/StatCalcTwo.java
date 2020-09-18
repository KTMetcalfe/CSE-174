// Kian Metcalfe
// CSE 174, Section D
// 9/18/20

// This program takes in a set of exam scores and calculates various values.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StatCalcTwo {
    public static void main(String[] args) throws FileNotFoundException {
        // Introduction
        System.out.println("Welcome to the Updated Stats Calculator!\n");

        // Creates scanner, recieves filename input, then closes scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the filename of your exam scores: ");
        File filename = new File(input.next());
        input.close();

        // Checks for empty file and prints out calculated values
        if (filename.length() == 0) {
            System.out.println("\nNo exam scores provided. "
                + "Stats not available.");
        } else {
            System.out.printf("\nThe average exam score was %.2f\n"
                + "The minimum exam score was %.2f\n"
                + "The maximum exam score was %.2f\n",
                scoreAverage(filename),
                scoreMinimum(filename),
                scoreMaximum(filename));
        }
    }

    // Calculates the average score from the values in the file
    public static double scoreAverage(File file) throws FileNotFoundException {
        double average = 0;
        int count = 0;

        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextDouble()) {
            average += fileReader.nextDouble();
            count++;
        }
        average /= count;
        fileReader.close();

        return average;
    }

    // Calculates the minimum score from the values in the file
    public static double scoreMinimum(File file) throws FileNotFoundException {
        double minimum = 100;
        double compare = 0;

        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextDouble()) {
            compare = fileReader.nextDouble();
            if (compare < minimum) {
                minimum = compare;
            }
        }
        fileReader.close();

        return minimum;
    }

    // Calculates the maximum score from the values in the file
    public static double scoreMaximum(File file) throws FileNotFoundException {
        double maximum = 0;
        double compare = 0;

        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextDouble()) {
            compare = fileReader.nextDouble();
            if (compare > maximum) {
                maximum = compare;
            }
        }
        fileReader.close();

        return maximum;
    }
}
