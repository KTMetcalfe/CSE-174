// Kian Metcalfe
// CSE 174, Section D
// 10/16/20

// This program is comprised of various static methods

import java.util.Scanner;

public class StaticMethods {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean end = false;
        String str = "";
        int sh = 0;

        do {
            System.out.print("1. Test addPound method.\n"
                + "2. Test swapChars method.\n3. Test shift method.\n"
                + "4. exit.\nEnter a number [1-4]: ");
            int option = in.nextInt();
            if (option >= 1 && option <= 3) {
                System.out.print("Enter a string:");
                str = in.next();
                if (option == 3) {
                    System.out.print("Enter the shift value: ");
                    sh = in.nextInt();
                }
            }

            switch (option) {
                case 1:
                    System.out.println(addPound(str));
                    break;
                case 2:
                    System.out.println(swapChars(str));
                    break;
                case 3:
                    System.out.println(shift(str, sh));
                    break;
                case 4:
                    end = true;
                    break;
                default: System.out.println("\nInvalid Input");
            }
        } while (!end);
    }

    public static String addPound(String addTo) {
        String pounded = "";

        for (int i = 0; i < addTo.length(); i++) {
            pounded += addTo.charAt(i) + "#";
        }

        return pounded;
    }

    public static String swapChars(String swapThis) {
        String swapped = "";

        for (int i = 0; i < swapThis.length(); i++) {
            if (swapThis.charAt(i) != '#') {
                swapped += (int) swapThis.charAt(i);
            } else {
                swapped += "#";
            }
        }

        return swapped;
    }

    public static String shift(String shiftThis, int byAmount) {
        String shifted = "";
        int newInt = 0;

        for (int i = 0; i < shiftThis.length(); i++) {
            newInt = (int) shiftThis.charAt(i) + byAmount;
            if (newInt > 90) {
                newInt -= 26;
            }
            shifted += (char) newInt;
        }

        return shifted;
    }
}
