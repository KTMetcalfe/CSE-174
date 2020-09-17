package Labs.Lab2;

// Kian Metcalfe
// CSE 174, Section D
// 8/28/20

// This program calculates the amount of dozens of donuts produced 
// and prints the remainder.

public class Donuts {
    public static void main(String[] args) {
        int dailyDonuts = 1735;
        int dozens = (dailyDonuts / 12);
        int extras = (dailyDonuts % 12);
        
        System.out.println(dailyDonuts + " daily donuts:");
        System.out.println(dozens + " dozens");
        System.out.println(extras + " extra donuts");
    }
}