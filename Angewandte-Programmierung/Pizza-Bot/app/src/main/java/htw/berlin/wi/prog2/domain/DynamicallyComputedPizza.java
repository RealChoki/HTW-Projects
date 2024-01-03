package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DynamicallyComputedPizza implements Pizza {

    private final List<Ingredient> ingredients;

    public DynamicallyComputedPizza(List<Ingredient> ingredients) {
        this.ingredients = Collections.unmodifiableList(ingredients);
    }

    @Override
    public BigDecimal calculatePrice() {
        return ingredients.stream().map(Ingredient::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public int calculateCalories() {
        return ingredients.stream().reduce(0, (subtotal, ing) -> subtotal + ing.getCalories(), Integer::sum);
    }

    @Override
    public List<String> getIngredientNames() {
        return ingredients.stream().map(Ingredient::getName).collect(Collectors.toUnmodifiableList());
    }
}
