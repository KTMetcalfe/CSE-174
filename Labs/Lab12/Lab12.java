// Kian Metcalfe
// CSE 174, Section D
// 11/5/20

public class Lab12 {
    public static void main(String[] args) {
        int[][] arr1 = {{0, -1}, {1, 2}, {10, 2}};
        int[][] arr2 = {{0, -1}, {1, 2}, {10, 2, 5}, {3}};
        System.out.println(getNumRows(arr1));
        System.out.println(getRowLength(arr2, 3));
        System.out.println(getRowLength(arr2, -1));
        System.out.println(getRowLength(arr2, 5));
        changeElem(arr2, 2, 0, 300);
        display(arr2);
    }

    public static int getNumRows(int[][] num) {
        return num.length;
    }

    public static int getRowLength(int[][] num, int index) {
        if (index > -1 && index < getNumRows(num)) {
            return num[index].length;
        } else {
            return 0;
        }
    }

    public static void changeElem(int[][] num, int indexR,
        int indexC, int newVal) {
        if ((indexR > -1 && indexR < getNumRows(num))
            && (indexC > -1 && indexC < getRowLength(num, indexR))) {
            num[indexR][indexC] = newVal;
        }
    }

    public static void display(int[][] num) {
        for (int[] col : num) {
            for (int i : col) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
