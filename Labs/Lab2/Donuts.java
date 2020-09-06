// Kian Metcalfe
// CSE 174, Section D
// 8/28/20

// This program calculates the amount of dozens of donuts produced 
// and prints the remainder.

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Donuts {
    public static void main(String[] args) throws FileNotFoundException {
        int dailyDonuts = 1735;
        int dozens = (dailyDonuts / 12);
        int extras = (dailyDonuts % 12);
        int gpa = 1234567;
        
        System.out.println(dailyDonuts + " daily donuts:");
        System.out.println(dozens + " dozens");
        System.out.println(extras + " extra donuts");
        
        PrintWriter write = new PrintWriter(new File("data.txt"));
    }
}