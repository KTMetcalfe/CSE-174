// Kian Metcalfe
// CSE 174, Section D
// 8/28/20

// This program calculates the area of a trapezoid 
// when given its two bases and height.

public class TrapCalc {
    public static void main(String[] args) {
        double base1 = 2.7;
        double base2 = 13.8;
        double height = 10.0;
        double area = (0.5) * (base1 + base2) * (height);
        
        System.out.println("Computing the area of a trapezoid...");
        System.out.println("base1 = " + base1 + ", base2 = " + base2
            + ", height = " + height);
        System.out.println("area of trapezoid = " + area);
    }
}