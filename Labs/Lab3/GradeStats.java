// Kian Metcalfe
// CSE 174, Section D
// 9/3/20

// This program takes a name and 3 tests scores,
// and provides calculated results based on user inputs

import java.util.Scanner;

public class GradeStats {
    public static void main(String[] args) {
        //Introduces the user to the program
        System.out.println("Welcome to my \"Stats Calculator\" program!");
        System.out.print("Enter student's first name: ");

        //Declares scanner and takes in a name
        Scanner input = new Scanner(System.in);
        String firstName = input.next();

        //Creates a double array, takes in 3 test scores, and closes scanner
        double[] grades = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print(firstName + "'s grade on exam " + (i + 1) + ": ");
            grades[i] = input.nextDouble();
        }
        input.close();

        //Calculates average, minumum, and maximum grades
        double gradeAverage = (grades[0] + grades[1] + grades[2]) / 3.0;
        double gradeMinimum = Math.min(grades[2],
            Math.min(grades[0], grades[1]));
        double gradeMaximum = Math.max(grades[2],
            Math.max(grades[0], grades[1]));

        //Prints the calculated results
        System.out.println("\n///// RESULTS (rounded) \\\\\\\\\\");
        System.out.printf("You entered: %.5f, %.5f, %.5f%n",
            grades[0], grades[1], grades[2]);
        System.out.printf(firstName + "'s average is %.1f.%n", gradeAverage);
        System.out.printf(firstName + "'s minimum is %.1f.%n", gradeMinimum);
        System.out.printf(firstName + "'s maximum is %.1f.%n", gradeMaximum);
    }
}
