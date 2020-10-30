public class PizzaShop {
    public static void main(String[] args) {
        Pizza p1 = new Pizza("small", "stuffed");
        p1.addTopping("pepperoni");
        p1.addTopping("onions");
        p1.setDelivery(true);
        System.out.println(p1.toString());

        Pizza p2 = new Pizza(47);
        System.out.println(p2.toString());
    }

    public static double pizzaCost(Pizza p) {
    /*
      $4 for small, $5.50 for medium, $7 for large
      Stuffed crust: $1 extra for small, $2 for medium, $3 for large
      No extra charge for thin/thick
      Toppings $0.75 each. However, there an additional $0.50 charge if
         at least one of the toppings is anchovies.
         For example, if the toppings are: anchovies, anchovies, onions,
           and pepperoni, then the toppings charge will be $3.50
           (4 toppings cost $3.00, and an extra 50 cents because at least
           one of the toppings is anchovies).
      Delivery: $2 (free for pizzas costing $10 or more)
      */

      double cost = 0.0;

      if (p.getSize().equals("small")) {
          cost = 4.0;
      } else if (p.getSize().equals("medium")) {
          cost = 5.5;
      } else if (p.getSize().equals("large")) {
          cost = 7.0;
      }

      switch (p.getSize()) {
          case "small":
              break;
          case "medium":
              break;
          case "large":
      }

      return totalCost;
    }
}
