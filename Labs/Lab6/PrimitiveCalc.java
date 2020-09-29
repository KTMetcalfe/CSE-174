// Kian Metcalfe
// CSE 174, Section D
// 9/25/20

// This program...

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.lang.ArithmeticException;

public class PrimitiveCalc {
    public static void main(String[] args) {
        // Gets filename as input and creates scanner to read the file.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        String filename = input.next();
        System.out.println("");
        File theFile = new File(filename);
        try {
            Scanner fileScanner = new Scanner(theFile);
            input.close();


            // Creates a scanner for each line in the file, finds the operator,
            // and prints out the resulting calculation using the numbers.
            String lineCurrent = "";
            String operator = "";
            int total = 0;
            for (int lineNumber = 1; fileScanner.hasNextLine(); lineNumber++) {
                lineCurrent = fileScanner.nextLine();
                Scanner lineReader = new Scanner(lineCurrent);

                operator = lineReader.next();
                total = lineReader.nextInt();

                System.out.printf("Result of Line %d: ", lineNumber);
                try {
                    while (lineReader.hasNext()) {
                        switch (operator) {
                            default:
                                total += lineReader.nextInt();
                                break;
                            case "-":
                                total -= lineReader.nextInt();
                                break;
                            case "*":
                                total *= lineReader.nextInt();
                                break;
                            case "/":
                                total /= lineReader.nextInt();
                                break;
                        }
                    }
                    System.out.println(total);
                } catch (ArithmeticException e) {
                    System.out.printf("Error: %s\n", e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.printf("Non-integer input on this Line\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
