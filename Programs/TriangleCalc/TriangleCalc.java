// Kian Metcalfe
// 9/9/20

// This program uses the rule of cosines to calculate various values of 
// a triangle using known values of sides (a, b, c) and/or an angle (Y)

import java.util.Scanner;

public class TriangleCalc {
    public static void main(String[] args) {
        // Starts intro and recieves unknown variable
        Introduction();
        Scanner input = new Scanner(System.in);
        char unknownVar = input.next().charAt(0);

        // Takes in known variables as string, seperates them at ","
        // then prints out seperated variables
        System.out.printf("%nEnter the 3 known variables in order, " + 
            "seperated by commas.     Ex: \"a,c,Y\"    ");
        String numList = input.next();
        double num1 = Double.parseDouble(numList.substring(
            0, numList.indexOf(',')));
        double num2 = Double.parseDouble(numList.substring(
            numList.indexOf(',') + 1, numList.lastIndexOf(',')));
        double num3 = Double.parseDouble(numList.substring(
            numList.lastIndexOf(',') + 1, numList.length()));
        System.out.printf("%n%.2f, %.2f, %.2f%n", num1, num2, num3);

        input.close();

        // Chooses what math to use based on unknown variable
        switch (unknownVar) {
            case 'a':
                System.out.printf("%.2f%n", calculate_a(num1, num2, num3));
                break;
            case 'b':
                System.out.printf("%.2f%n", calculate_b(num1, num2, num3));
                break;
            case 'c':
                System.out.printf("%.2f%n", calculate_c(num1, num2, num3));
                break;
            default:
                System.out.printf("%.2f%n", calculate_Y(num1, num2, num3));
                break;
        }
    }

    //Prints out basic introductory information 
    //and asks the important question
    public static void Introduction() {
        System.out.printf(
            "Example Triangle:%n%n" + 
            "        _                     %n" + 
            "       / \\__                  %n" + 
            "      /     \\__               %n" + 
            "  a  /         \\__            %n" + 
            "    /             \\__     c   %n" + 
            "   /                 \\__      %n" + 
            "  / \\                   \\__   %n" + 
            " / Y \\                     \\_ %n" +
            "< -- -- -- -- -- -- -- -- -- >%n" + 
            "              b               %n%n" + 
            "What variable would you like to calculate? "
        );
    }

    // Math is in relation to angle (Y), which is across from side (c)
    public static double calculate_a(double b, double c, double Y) {
        Y = Math.toRadians(Y);
        double a = (b * Math.cos(Y)) + Math.sqrt(
            (c * c) - ((b * b) * (Math.sin(Y) * Math.sin(Y))));
        return a;
    }

    // Math is in relation to angle (Y), which is across from side (c)
    public static double calculate_b(double a, double c, double Y) {
        Y = Math.toRadians(Y);
        double b = (a * Math.cos(Y)) + Math.sqrt(
            (c * c) - ((a * a) * (Math.sin(Y) * Math.sin(Y))));
        return b;
    }

    // c^2 = a^2 + b^2 - 2bc * cos(Y)
    public static double calculate_c(double a, double b, double Y) {
        Y = Math.toRadians(Y);
        double c = Math.sqrt((a * a) + (b * b) - (2.0 * a * b * Math.cos(Y)));
        return c;
    }

    // cos(Y) = (a^2 + b^2 - c^2) / (2 * a * b)
    public static double calculate_Y(double a, double b, double c) {
        double Y = Math.toDegrees(Math.acos(((a * a) + (b * b) - (c * c)) / 
            (2.0 * a * b)));
        return Y;
    }
}
