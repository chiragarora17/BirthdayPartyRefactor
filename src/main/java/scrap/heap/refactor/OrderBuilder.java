package scrap.heap.refactor;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author carora
 * @since 8/9/19
 */
public class OrderBuilder {

  private Map<Item, Integer> items = new LinkedHashMap<>();

  public OrderBuilder addItem(Item i, int quantity) {
    items.put(i, items.getOrDefault(i, 0) + quantity);
    return this;
  }

  public OrderBuilder addItem(Item i) {
    addItem(i, 1);
    return this;
  }

  public Balloon.Builder balloon() {
    return new Balloon.Builder(this);
  }

  public Cake.Builder cake() {
    return new Cake.Builder(this);
  }

  public Order buildOrder() {
    return new Order(items);
  }
}
