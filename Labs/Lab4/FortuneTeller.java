// Kian Metcalfe
// CSE 174, Section D
// 9/10/20

// This program creates a fortune for you based on...

import java.util.Scanner;
import java.util.logging.*;

public class FortuneTeller {
    public static void main(String[] args) {
        // Turns off degugging logger
        Logger.getGlobal().setLevel(Level.OFF);

        // Creates scanner, recieves information, then closes scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to CSE 174 Fortune Telling!\n");
        System.out.print("What is your first name? ");
        String name = input.next();
        System.out.print("What is your favorite color " 
            + "(red, green, blue, yellow, orange, purple)? ");
        String color = input.next();
        System.out.print("What year were you born? ");
        int year = input.nextInt();
        System.out.print("On a scale of 1 (bad) to 10 (great)"
            + ", how do you feel? ");
        int feeling = input.nextInt();
        System.out.print("True/False: Pineapple belongs on Pizza? ");
        boolean pineapple = input.nextBoolean();

        input.close();
        
        // Logs input variables
        Logger.getGlobal().info("Input variables: " + name + ", " + color + ", " + year + ", " + feeling + ", " + pineapple);

        // Prints output using "blank" methods
        System.out.printf("\n%s,\n", name);
        System.out.printf("\nYou will have a %s day.", blank1(name));
        System.out.printf("\nYou should watch out for %s today.", 
            blank2(color));
        System.out.printf("\nFocus your priorities on %s for the next week.", 
            blank3(year));
        System.out.printf("\nTo be your best you, make sure you don't %s.", 
            blank4(feeling));
        System.out.printf("\nOur parting words of wisdom are: \"%s\".", 
            blank5(pineapple));
    }

    // Creates blank1 and uses ascii to compare first letter of name
    public static String blank1(String name) {
        String result = "blank1";
        char letter = name.toLowerCase().charAt(0);
        Logger.getGlobal().info("Lowercase first letter: " + letter);

        if (letter >= 97 && letter <= 102) { // a - f
            result = "good";
        } else if (letter >= 103 && letter <= 108) { // g - l
            result = "great";
        } else if (letter >= 109 && letter <= 115) { // m - s
            result = "bad";
        } else if (letter >= 116 && letter <= 122) { // t - z
            result = "horrible";
        }

        return result;
    }

    // Creates blank2 and uses a switch statement to decide output
    public static String blank2(String color) {
        String result = "blank2";
        color = color.toLowerCase();
        Logger.getGlobal().info("Lowercase color: " + color);

        switch (color) {
            case "red":
                result = "spilling on your clothes";
                break;
            case "green":
                result = "con artists";
                break;
            case "blue":
                result = "unexpected rain";
                break;
            case "yellow":
                result = "overly happy people";
                break;
            case "orange":
                result = "a bad sunburn";
                break;
            case "purple":
                result = "friendly dinosaurs";
                break;
        }

        return result;
    }

    // Creates blank3 and sets it based on year born
    public static String blank3(int year) {
        String result = "blank3";

        if (year >= 2001) {
            result = "your studies";
        } else if (year >= 1991 && year <= 2000) {
            result = "your health";
        } else if (year >= 1981 && year <= 1990) {
            result = "career goals";
        } else if (year <= 1980) {
            result = "retirement options";
        }

        return result;
    }

    // Creates blank4 and sets result based on feeling
    public static String blank4(int feeling) {
        String result = "blank4";

        if (feeling >= 1 && feeling <= 3) {
            result = "skip breakfast";
        } else if (feeling >= 4 && feeling <= 6) {
            result = "ignore a loved one";
        } else if (feeling >= 7 && feeling <= 9) {
            result = "forget your wallet";
        } else if (feeling == 10) {
            result = "change a thing";
        }

        return result;
    }

    // Creates blank5 and sets result based on preference
    public static String blank5(boolean pineapple) {
        String result = "blank5";

        result = pineapple == true ? "Enjoy the little things in life" : "Open your mind to new possibilities";

        return result;
    }
}
