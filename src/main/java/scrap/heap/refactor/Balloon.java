package scrap.heap.refactor;

import java.util.Objects;

/**
 * @author carora
 * @since 8/9/19
 */
class Balloon implements Item {

  private final Color color;
  private final String material;

  private Balloon(Color color, String material) {
    this.color = color;
    this.material = material;
  }

  public Color getColor() {
    return color;
  }

  public String getMaterial() {
    return material;
  }

  @Override
  public String display() {
    return String.join(" ", "Balloons:", "Color:", color.toString().toLowerCase(), "Material:",
      material);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Balloon balloon = (Balloon) o;
    return Objects.equals(color, balloon.color)
      && Objects.equals(material, balloon.material);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, material);
  }

  /**
   * Builder to build balloons
   */
  static class Builder {

    // Composite pattern and builder of Builders
    private Color color;
    private String material;
    private OrderBuilder orderBuilder;
    private int quantity;

    public Builder(OrderBuilder orderBuilder) {
      this.orderBuilder = orderBuilder;
    }

    public Builder color(String color) {
      this.color = Color.valueOf(color.toUpperCase());
      return this;
    }

    public Builder material(String material) {
      this.material = material;
      return this;
    }

    public Builder quantity(String quantity) {
      this.quantity = Integer.valueOf(quantity);
      return this;
    }

    OrderBuilder build() {
      if ((color == null && material == null) || quantity <= 0) {
        return orderBuilder;
      }
      Balloon b = new Balloon(color, material);
      orderBuilder.addItem(b, quantity);
      return orderBuilder;
    }
  }
}
