package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;

public class Topping extends AbstractIngredient {
    public Topping(String name, BigDecimal price, int calories) {
        super(name, price, calories);
    }

    @Override
    public String toString() {
        return this.getName() + " als Topping";
    }

    @Override
    public Category getCategory() {
        return Category.TOPPING;
    }
}
