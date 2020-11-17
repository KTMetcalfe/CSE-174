// Kian Metcalfe
// CSE 174, Section D
// 11/13/20

// This program shows off binary and linear search algorythms

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab13 {
    public static void main(String[] args) throws FileNotFoundException {
        File filename = new File("customer_list.txt");
        Scanner input = new Scanner(filename);
        int numLines = 0;

        while (input.hasNextLine()) {
            input.nextLine();
            numLines++;
        }

        //System.out.printf("There are %d lines in the file\n", numLines);

        Customer[] people = new Customer[numLines];

        input = new Scanner(filename);

        int count = 0;
        while (input.hasNext()) {
            String name = input.next();
            long id = input.nextLong();
            Customer person = new Customer(name, id);

            people[count] = person;
            count++;
        }

        //System.out.printf("[0]: %s\n", people[0]);
        //System.out.printf("[10]: %s\n", people[10]);
        //System.out.printf("[1000]: %s\n", people[1000]);
        //System.out.printf("[1000000]: %s\n", people[1000000]);
        //System.out.printf("[%d]: %s\n", count - 1, people[count - 1]);

        Customer key = new Customer("qwstikg", 100005949);
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            linearSearch(people, key));
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            binarySearch(people, key));
        key = new Customer("mqzhfqgjuk", 6001073675L);
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            linearSearch(people, key));
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            binarySearch(people, key));
        key = new Customer("gnv", 7412760286L);
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            linearSearch(people, key));
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            binarySearch(people, key));
        key = new Customer("CSE174", 1111111111);
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            linearSearch(people, key));
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            binarySearch(people, key));

            
        key = new Customer("fbs", 9919190204L);
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            linearSearch(people, key));
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            binarySearch(people, key));
        key = new Customer("odmpup", 9927650133L);
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            linearSearch(people, key));
        System.out.printf("The object %s located at the index of: %d\n\n", key,
            binarySearch(people, key));
    }

    public static int linearSearch(Customer[] people, Customer person) {
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            count++;
            if (people[i].equals(person)) {
                System.out.printf("Linear Search:"
                    + " The key is found after %d comparison\n", count);
                return i;
            }
        }
        System.out.printf("Linear Search:"
            + " The key is found after %d comparison\n", count);
        return -1;
    }

    public static int binarySearch(Customer[] people, Customer person) {
        int count = 0;

        int min = 0;
        int max = people.length - 1;

        while (max > min) {
            int mid = (min + max) / 2;
            count++;
            if (people[mid].getId() == person.getId()) {
                System.out.printf("Binary Search:"
                    + " the key is found after %d comparison\n", count);
                return mid;
            } else if (people[mid].getId() < person.getId()) {
                min = mid + 1;
            } else if (people[mid].getId() > person.getId()) {
                max = mid - 1;
            }
        }
        System.out.printf("Binary Search:"
            + " the key is found after %d comparison\n", count);
        return -1;
    }
}
