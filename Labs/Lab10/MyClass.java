// Kian Metcalfe
// CSE 174, Section D
// 10/23/20

// This program has various overloaded methods that
// places strings in the middle of other strings.

public class MyClass {
    public static void main(String[] args) {
        System.out.println(addMiddle("aaaa", 0, "b"));
        System.out.println(addMiddle("aaaa", 4, "b"));
        System.out.println(addMiddle("aaaa", 2, "b"));
        System.out.println(addMiddle("", 0, "empty"));

        System.out.println(addMiddle("aaaa", 3, 'r'));
        System.out.println(addMiddle("aaaa", 0, 'r'));
        System.out.println(addMiddle("aaaa", 4, 'r'));
        System.out.println(addMiddle("aaaa", 5, 'r'));
        System.out.println(addMiddle("", 0, 'E'));

        System.out.println(addMiddle(12345, 0, 0));
        System.out.println(addMiddle(11111, 5, 0));
        System.out.println(addMiddle(11111, 4, 222));
    }

    // Returns a string (str) based on the recieved original string,
    // a string (newStr) to insert, and the index (index) to insert it at.
    public static String addMiddle(String str, int index, String newStr) {
        // Verifies that the index is within the length on the string
        if (index >= 0 && index <= str.length()) {
            return (str.substring(0, index) + newStr + str.substring(index));
        } else {
            return "";
        }
    }

    // Returns a string (str) based on the recieved original string,
    // a char (newCh) to insert, and the index (index) to insert it at.
    public static String addMiddle(String str, int index, char newCh) {
        // Verifies that the index is within the length on the string
        if (index >= 0 && index <= str.length()) {
            return (str.substring(0, index) + newCh + str.substring(index));
        } else {
            return "";
        }
    }

    // Returns an integer (num) based on the recieved original string,
    // a integer (newNum) to insert, and the index (index) to insert it at.
    public static String addMiddle(int num, int index, int newNum) {
        // Calls string version of the addMiddle method
        return addMiddle("" + num, index,"" + newNum);
    }
}
