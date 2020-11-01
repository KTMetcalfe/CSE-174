// Kian Metcalfe
// CSE 174, Section D
// 10/30/20

// This program interacts with the pizza class to complete full functionality
// of ordering a pizza

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PizzaShop {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter order filename: ");
        String fileName = kb.next();
        pizzaOrder(fileName);
    }

    /**
    Creates a complete pizza order and outputs all of the various results.
    @param fileName the name of the file including the pizza instructions
    */
    public static void pizzaOrder(String fileName) {
        // Catches any exceptions that do not fall in line
        // with our pizza instruction requirements
        try {
            File theFile = new File(fileName);
            Scanner reader = new Scanner(theFile);

            String size = reader.next();
            String crust = reader.next();
            boolean delivery = reader.next().equals("delivery");

            // Throws exception for incorrect size or crust instructions
            if (size.equals("small") && size.equals("medium")
                && size.equals("large")) {
                throw new IllegalArgumentException("INVALID SIZE: " + size);
            }
            if (crust.equals("thin") && crust.equals("stuffed")
                && crust.equals("thick")) {
                throw new IllegalArgumentException("INVALID CRUST: " + crust);
            }

            // Creates pizza order, adds all the various toppings,
            // and outputs the steps
            Pizza thisOrder = new Pizza(size, crust);
            thisOrder.setDelivery(delivery);
            System.out.println("---Toppings---");
            while (reader.hasNext()) {
                String topping = reader.next();
                if (!thisOrder.hasTopping(topping)) {
                    switch (topping) {
                        default:
                            System.out.printf("%s: TRY PAPA JOHNS.\n", topping);
                            break;
                        case "pepperoni":
                        case "mushrooms":
                        case "sausage":
                        case "bacon":
                        case "pineapple":
                        case "onions":
                        case "peppers":
                        case "steak":
                        case "ham":
                        case "chicken":
                        case "tomatoes":
                        case "anchovies":
                        case "spinach":
                        case "broccoli":
                        case "olives":
                            thisOrder.addTopping(topping);
                            System.out.printf("%s: added\n", topping);
                            break;
                    }
                } else {
                    System.out.printf("%s: DUPLICATE. NOT ADDED.\n", topping);
                }
            }

            // The main output for the completed order.
            System.out.println("---Here is your order---");
            System.out.println(thisOrder.toString());
            System.out.printf("Your total is $%.2f.\n", pizzaCost(thisOrder));
            System.out.println("---Have a nice day---");
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("INVALID ORDER. GOODBYE");
        }
    }

    /**
    Calculate the total cost of a given pizza.
    @param p the pizza for which the cost should be calculated
    @return the calculated cost of the pizza
    */
    public static double pizzaCost(Pizza p) {
        double cost = 0.0;

        // Sets base cost depending on the size
        switch (p.getSize()) {
            default:
                cost = 4.0;
                break;
            case "medium":
                cost = 5.5;
                break;
            case "large":
                cost = 7.0;
                break;
        }

        // Adds cost of stuffed crust depending on the size
        if (p.getCrust().equals("stuffed")) {
            switch (p.getSize()) {
                default:
                    cost += 1.0;
                    break;
                case "medium":
                    cost += 2.0;
                    break;
                case "large":
                    cost += 3.0;
                    break;
            }
        }

        // Adds the cost per topping
        cost += p.toppingCount() * 0.75;

        // Additional cost if at least one topping is anchovies
        if (p.hasTopping("anchovies")) {
            cost += 0.5;
        }

        // Adds delivery cost if the current cost is less than $10
        if (p.getDelivery() && cost < 10) {
            cost += 2.0;
        }

        return cost;
    }
}
