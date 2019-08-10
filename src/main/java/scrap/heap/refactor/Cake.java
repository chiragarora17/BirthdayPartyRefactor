package scrap.heap.refactor;

import java.util.Objects;

/**
 * @author carora
 * @since 8/9/19
 */
class Cake implements Item {

  private final String flavor;
  private final String frosting;
  private final String shape;
  private final String size;
  private final Color color;

  private Cake(String flavor, String frosting, String shape, String size, Color color) {
    this.flavor = flavor;
    this.frosting = frosting;
    this.shape = shape;
    this.size = size;
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public String getFlavor() {
    return flavor;
  }

  public String getFrosting() {
    return frosting;
  }

  public String getShape() {
    return shape;
  }

  public String getSize() {
    return size;
  }

  @Override
  public String display() {
    return String.join(" ", "Cake:", "Flavor:", flavor, "Frosting:", frosting, "Shape:", shape,
      "Size:", size, "Color:", color.toString().toLowerCase());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cake cake = (Cake) o;
    return Objects.equals(flavor, cake.flavor)
      && Objects.equals(frosting, cake.frosting)
      && Objects.equals(shape, cake.shape)
      && Objects.equals(size, cake.size)
      && color == cake.color;
  }

  @Override
  public int hashCode() {
    return Objects.hash(flavor, frosting, shape, size, color);
  }

  /**
   * Builder to build Cakes
   */
  static class Builder {

    private String flavor;
    private String frosting;
    private String shape;
    private String size;
    private Color color;
    private final OrderBuilder orderBuilder;

    public Builder(OrderBuilder orderBuilder) {
      this.orderBuilder = orderBuilder;
    }

    public Builder flavor(String flavor) {
      this.flavor = flavor;
      return this;
    }

    public Builder frosting(String frosting) {
      this.frosting = frosting;
      return this;
    }

    public Builder shape(String shape) {
      this.shape = shape;
      return this;
    }

    public Builder size(String size) {
      this.size = size;
      return this;
    }

    public Builder color(String color) {
      this.color = Color.valueOf(color.toUpperCase());
      return this;
    }

    OrderBuilder build() {
      if (flavor == null && frosting == null && size == null && shape == null && color == null) {
        return orderBuilder;
      }
      Cake cake = new Cake(flavor, frosting, shape, size, color);
      orderBuilder.addItem(cake);
      return orderBuilder;
    }
  }
}
