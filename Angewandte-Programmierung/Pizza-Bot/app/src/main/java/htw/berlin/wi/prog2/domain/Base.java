package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;

public class Base extends AbstractIngredient {
    public Base(String name, BigDecimal price, int calories) {
        super(name, price, calories);
    }

    @Override
    public String toString() {
        return this.getName() + "-Teig";
    }

    @Override
    public Category getCategory() {
        return Category.BASE;
    }
}
