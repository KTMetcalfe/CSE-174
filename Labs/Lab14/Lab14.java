// Kian Metcalfe
// CSE 174, Section D
// 11/19/20

// This program uses ArrayList and the Customer class.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Lab14 {
    static Scanner input = new Scanner(System.in);
    static boolean quit = false;
    static boolean readFile = false;
    static boolean sorted = false;
    static String filename = "";
    static File customerFile = new File(filename);
    static ArrayList<Customer> customerList = new ArrayList<>();
    static ArrayList<Customer> sortedList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        while (quit == false) {
            System.out.print("1. Load from a file\n"
                + "2. Print the loaded list\n"
                + "3. Sort the list based on the nicknames\n"
                + "4. sort the list based on the ids\n"
                + "5. Print the sorted list\n"
                + "6. Exit\n"
                + "Enter a number[1-6]: ");

            int answer = input.nextInt();

            if (answer == 1) {
                loadFile();
            } else if (answer == 6) {
                System.out.println("End!");
                quit = true;
            } else if (readFile) {
                parseAnswer(answer);
            } else {
                System.out.println("No data has been loaded yet!\n");
            }
        }
        input.close();
    }

    public static void loadFile() throws FileNotFoundException {
        System.out.print("\nEnter the name of the file: ");
        filename = input.next();
        customerFile = new File(filename);
        Scanner fileInput = new Scanner(customerFile);

        customerList.clear();
        while (fileInput.hasNext()) {
            customerList.add(new Customer(fileInput.next(),
                fileInput.nextLong()));
        }

        System.out.println("Loading from the file is done!\n");
        sorted = false;
        readFile = true;
        fileInput.close();
    }

    public static void parseAnswer(int answer) {
        switch (answer) {
            case 2:
                display(customerList);
                break;
            case 3:
                sortedList = new ArrayList<Customer>(customerList);
                sort1(sortedList);
                sorted = true;
                System.out.println("Sorting is done!\n");
                break;
            case 4:
                sortedList = new ArrayList<Customer>(customerList);
                sort2(sortedList);
                sorted = true;
                System.out.println("Sorting is done!\n");
                break;
            case 5:
                if (sorted) {
                    display(sortedList);
                } else {
                    System.out.println("Nothing is sorted yet!\n");
                }
                break;
            default:
                System.out.println("Failed!");
                quit = true;
                break;
        }
    }

    public static void sort1(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            while (j > 0 && list.get(j).getName().compareTo(
                list.get(j - 1).getName()) < 0) {
                Customer temp = list.get(j - 1);
                list.set(j - 1, list.get(j));
                list.set(j, temp);
                j--;
            }
        }
    }

    public static void sort2(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            while (j > 0 && list.get(j).getId() < list.get(j - 1).getId()) {
                Customer temp = list.get(j - 1);
                list.set(j - 1, list.get(j));
                list.set(j, temp);
                j--;
            }
        }
    }

    public static void display(ArrayList<Customer> list) {
        System.out.println("\n**** Printing the list ****");

        int count = 1;
        boolean print = true;
        while (print && count <= list.size()) {
            System.out.printf("%d. %s\n", count,
                list.get(count - 1).toString());
            if (count == list.size()) {
                System.out.println("");
            }
            if (count % 10 == 0) {
                System.out.print("Enter something to continue/"
                    + "enter s to stop: ");
                if (input.next().charAt(0) == 's') {
                    print = false;
                    System.out.println("");
                    break;
                }
            }
            count++;
        }
    }
}
