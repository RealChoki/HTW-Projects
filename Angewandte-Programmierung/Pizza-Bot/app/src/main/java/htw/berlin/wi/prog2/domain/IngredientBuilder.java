package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class IngredientBuilder {

    private String name;
    private BigDecimal price;
    private int calories;

    public IngredientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public IngredientBuilder setPrice(String price) {
        this.price = new BigDecimal(price);
        return this;
    }

    public IngredientBuilder setCals(int calories) {
        this.calories = calories;
        return this;
    }

    public Ingredient build(Ingredient.Category cat) {
        return switch (cat) {
            case BASE -> new Base(name, price, calories);
            case PROTEIN -> new Protein(name, price, calories);
            case TOPPING -> new Topping(name, price, calories);
            case SAUCE -> new Sauce(name, price, calories);
        };
    }
}
