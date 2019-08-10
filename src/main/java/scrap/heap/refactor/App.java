package scrap.heap.refactor;

public class App {
  public String getGreeting() {
    return "Hello world.";
  }

  public static void main(String[] args) {

    //Place birthday party orders
    order("red", "mylar", "4", "chocolate", "chocolate", "circle", "large", "brown");
    order("blue", "latex", "7", "Vanilla", "chocelate", "square", "med", "brown");
    order("yellow", "mylar", "4", "vanilla", "vanilla", "square", "small", "yellow");

  }

  /**
   * This method acts like an adaptor without breaking client side contract which is main method.
   */
  private static void order(String balloonColor, String material, String number, String flavor, String frostingFlavor,
                            String shape, String size, String cakeColor) {

    Order order = new OrderBuilder()
      .balloon()
        .color(balloonColor)
        .material(material)
        .quantity(number)
        .build()
      .cake()
        .color(cakeColor)
        .flavor(flavor)
        .frosting(frostingFlavor)
        .shape(shape)
        .size(size)
        .build()
      .buildOrder();

    System.out.println(order.display());
  }
}
