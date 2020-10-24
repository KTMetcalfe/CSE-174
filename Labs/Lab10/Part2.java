// Kian Metcalfe
// CSE 174, Section D
// 10/23/20

// This program asks the user to select a menu option, then calls a
// class based on the answer and subsequent inputs

import java.util.Scanner;

public class Part2 {
    // Global scanner (in) variable
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean end = false;

        do {
            switch (menu()) {
                case 1: System.out.println(case1());
                    break;
                case 2: System.out.println(case2());
                    break;
                case 3: System.out.println(case3());
                    break;
                case 4: end = true;
                    break;
                default:
                    System.out.println("Invalid Input!!");
            }
        } while (!end);

        System.out.println("END!");
    }

    // Shows a menu and asks user for and interger to select the correct option,
    // and then returns given input
    public static int menu() {
        System.out.println("Lab10\n"
            + "1- addMiddle with string\n"
            + "2- addMiddle with char\n"
            + "3- addMiddle with int\n"
            + "4- Exit");
        System.out.print("Enter a number [1-4]: ");

        return in.nextInt();
    }

    // The method call for when we want to add a string into the middle of
    // another string at a given index
    public static String case1() {
        System.out.print(
            "Enter one string, one int, and another string in order: "
        );

        return MyClass.addMiddle(in.next(), in.nextInt(), in.next());
    }

    // The method call for when we want to add a character into the middle of
    // a string at a given index
    public static String case2() {
        System.out.print(
            "Enter one string, one int, and one character in order: "
        );

        return MyClass.addMiddle(in.next(), in.nextInt(), in.next().charAt(0));
    }

    // The method call for when we want to add an interger into the middle of
    // another integer at a given index
    public static String case3() {
        System.out.print(
            "Enter three integers: "
        );

        return MyClass.addMiddle(in.nextInt(), in.nextInt(), in.nextInt());
    }
}
