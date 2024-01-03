package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;

public class Sauce extends AbstractIngredient {
    public Sauce(String name, BigDecimal price, int calories) {
        super(name, price, calories);
    }

    @Override
    public String toString() {
        return this.getName() + " als Sauce";
    }

    @Override
    public Category getCategory() {
        return Category.SAUCE;
    }
}
