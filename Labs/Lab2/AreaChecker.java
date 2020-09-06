// August 23, 2020
// Author: Kian M
// Computes the area of a rectangle using two sets of values.

public class AreaChecker {
    public static void main(String[] args) {
        int base = 10;
        int height = 5;
        int area = base * height;
        
        System.out.println("base = " + base);
        System.out.println("height = " + height);
        System.out.println("area = " + area);
        
        System.out.println("Adjusting base and height to 7 and 5:");
        base = 7;
        height = 5;
        area = base * height;
        
        System.out.println("base = " + base);
        System.out.println("height = " + height);
        System.out.println("area = " + area);        
    }
}