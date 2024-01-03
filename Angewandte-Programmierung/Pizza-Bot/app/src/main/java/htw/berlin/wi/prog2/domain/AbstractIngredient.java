package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractIngredient implements Ingredient {
    private final String name;
    private final BigDecimal price;
    private final int calories;

    public AbstractIngredient(String name, BigDecimal price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() { return this.getName(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractIngredient)) return false;

        AbstractIngredient that = (AbstractIngredient) o;

        if (getCalories() != that.getCalories()) return false;
        if (!getName().trim().equals(that.getName().trim())) return false;
        return getPrice().compareTo(that.getPrice()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().trim(), price.doubleValue());
    }
}
