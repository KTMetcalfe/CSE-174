// Kian Metcalfe
// 9/20/2020

// This program is designed to help solve some basic physics equations using an
// unknown variable (varUnknown) and known variables (num_) provided by input

import java.util.Scanner;

public class PhysicsHelper {
    // Declares the variables for the strings that need to be parsed
    static String varUnknown;
    static String varKnown;

    // Declares the variables for the ints that have been parsed from the strigs
    static double num_x;
    static double num_x0;
    static double num_v;
    static double num_v0;
    static double num_a;
    static double num_t;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Introduction(input);
        input.close();

        parseKnown();
    }

    // Prints out Introduction statement and recieves variables
    public static void Introduction(Scanner in) {
        System.out.println("Welcome to Kian's Physics Helper Program!\n");

        // Recieves unknown variable as a string
        System.out.println("Enter the variable you are trying "
            + "to find the value of.");
        System.out.println("Supported variables - (x, x0, v, v0, a, t)");
        System.out.print("Unkown variable: ");
        varUnknown = in.next();

        // Recieves known variables as a single string to be parsed
        System.out.println("\nEnter the known variables and "
            + "their values as listed below.");
        System.out.println("Example layout - (x0=90,v=-40,v0=0,a=-9.8)");
        System.out.print("Known variables: (");
        varKnown = in.next();
        System.out.println("\n");
    }

    public static void parseKnown() {

    }
}
