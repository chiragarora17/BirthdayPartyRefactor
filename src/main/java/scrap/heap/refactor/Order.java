package scrap.heap.refactor;

import java.util.Map;

/**
 * @author carora
 * @since 8/9/19
 */
public class Order implements DisplayableItem {

  /**
   * Following composite pattern. Order implement Item and Balloon, cake also implements Items
   */
  private final Map<Item, Integer> items;

  Order(Map<Item, Integer> items) {
    this.items = items;
  }

  @Override
  public String display() {
    if (items.isEmpty()) {
      return null;
    }
    StringBuilder invoice = new StringBuilder();
    invoice.append("Order Details");
    invoice.append("\n");
    for (Map.Entry<Item, Integer> menuItem : items.entrySet()) {
      invoice.append(menuItem.getKey().display());
      invoice.append("\n");
      invoice.append("Quantity:" + Integer.toString(menuItem.getValue()));
      invoice.append("\n");
    }
    invoice.append("\n");
    return invoice.toString();
  }
}
