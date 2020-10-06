// Kian Metcalfe
// CSE 174, Section D
// 10/5/20

// This program counts from 1 to 100 and prints out a counter
// instead of every 4th number using a (while loop)

public class whileloop {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 100) {
            if (i % 4 == 0) {
                System.out.printf("(%d) ", (i / 4));
            } else {
                System.out.printf("%d ", i);
            }
            i++;
        }
    }
}
