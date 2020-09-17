// Kian Metcalfe
// CSE 174, Section D
// 9/17/20

// This program helps you count by recieving a starting value, ending value, 
// and a +/- interation value, then printing out the resulting numbers.

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CountHelper {
    public static void main(String[] args) {
        // Turns off debugging logger
        Logger.getGlobal().setLevel(Level.OFF);

        // Creates scanner, recieves values, and closes scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to CSE 174 Counter Helper!\n");
        System.out.print("Enter the starting value to count from: ");
        int valueStart = input.nextInt();
        System.out.print("Enter the ending value to count to: ");
        int valueEnd = input.nextInt();
        System.out.print("Enter step value" 
            + "(positive #s count up/negative count down): ");
        int valueIteration = input.nextInt();

        input.close();

        // Logs input values to check for errors
        Logger.getGlobal().info("Input values: " + valueStart + ", " + valueEnd 
            + ", " + valueIteration);

        System.out.printf("\nCount: %s", 
            valueList(valueStart, valueEnd, valueIteration));
    }

    // Calculates values and adds them to a string that is returned
    public static String valueList(int start, int end, int iteration) {
        String values = "";

        if (start < end && iteration > 0) {
            for (int i = start; i <= end; i = i + iteration) {
                values = values + " " + i; 
            }
            Logger.getGlobal().info("Up: " + values);
        } else if (start > end && iteration < 0) {
            for (int i = start; i >= end; i = i + iteration) {
                values = values + " " + i; 
            }
            Logger.getGlobal().info("Down: " + values);
        } else {
            values = "You can't count from " + start + " to " + end 
                + " by " + iteration;
            Logger.getGlobal().info("Failed: " + values);
        }

        return values;
    }
}