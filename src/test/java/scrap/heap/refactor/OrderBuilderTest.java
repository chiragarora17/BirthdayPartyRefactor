package scrap.heap.refactor;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author carora
 * @since 8/9/19
 */
public class OrderBuilderTest {

  @Test
  public void testOrder() {
    Order order = new OrderBuilder()
      .balloon()
      .color("yellow")
      .material("latex")
      .quantity("1")
      .build()
      .cake()
      .color("brown")
      .flavor("chocolate")
      .frosting("white")
      .shape("circle")
      .size("large")
      .build()
      .buildOrder();

    String expected = "Order Details\n"
      + "Balloons: Color: yellow Material: latex\n"
      + "Quantity:1\n"
      + "Cake: Flavor: chocolate Frosting: white Shape: circle Size: large Color: brown\n"
      + "Quantity:1\n\n";
    Assert.assertEquals(expected, order.display());
  }

  @Test
  public void testSameOrderAgain() {
    Order order = new OrderBuilder()
      .balloon()
      .color("yellow")
      .material("latex")
      .quantity("1")
      .build()
      .balloon()
      .color("yellow")
      .material("latex")
      .quantity("3")
      .build()
      .cake()
      .color("brown")
      .flavor("chocolate")
      .frosting("white")
      .shape("circle")
      .size("large")
      .build()
      .cake()
      .color("brown")
      .flavor("chocolate")
      .frosting("white")
      .shape("circle")
      .size("large")
      .build()
      .buildOrder();

    String expected = "Order Details\n"
      + "Balloons: Color: yellow Material: latex\n"
      + "Quantity:4\n"
      + "Cake: Flavor: chocolate Frosting: white Shape: circle Size: large Color: brown\n"
      + "Quantity:2\n\n";

    Assert.assertEquals(expected, order.display());
  }

  @Test
  public void testEmptyOrder() {
    Order order = new OrderBuilder()
      .balloon()
      .build()
      .buildOrder();
    Assert.assertNull(order.display());
  }

  @Test
  public void testInvalidNumberOrder() {
    Order order = new OrderBuilder()
      .balloon()
      .color("yellow")
      .material("latex")
      .quantity("-1")
      .build()
      .buildOrder();

    Assert.assertNull(order.display());
  }

  @Test(expected = RuntimeException.class)
  public void testInvalidNumberOrderException() {
    Order order = new OrderBuilder()
      .balloon()
      .color("yellow")
      .material("latex")
      .quantity("test")
      .build()
      .buildOrder();

    Assert.assertNull(order.display());
  }
}
