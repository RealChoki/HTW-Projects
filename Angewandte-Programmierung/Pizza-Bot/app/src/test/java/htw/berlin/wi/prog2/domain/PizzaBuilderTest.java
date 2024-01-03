package htw.berlin.wi.prog2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaBuilderTest {

    private final PizzaBuilder builder = new PizzaBuilder();
    private final IngredientBuilder ingBuilder = new IngredientBuilder();

    private final Ingredient sauce = ingBuilder.setName("Tomatensauce").setPrice("0.01").setCals(2000).build(Ingredient.Category.SAUCE);
    private final Ingredient teig = ingBuilder.setName("Teig").setPrice("0.02").setCals(1000).build(Ingredient.Category.BASE);

    @Test
    @DisplayName("can build a precomputed pizza with two ingredients")
    void buildAPizza() {
        builder.setCreationStyle(PizzaBuilder.CreationStyle.PRECOMPUTED);
        Pizza pizza = builder.add(teig).add(sauce).build();

        assertEquals(List.of("Teig", "Tomatensauce"), pizza.getIngredientNames());
        assertEquals(new BigDecimal("0.03"), pizza.calculatePrice());
        assertEquals(3000, pizza.calculateCalories());
    }

    @Test
    @DisplayName("can build two precomputed pizzas after another without mixing things up")
    void buildTwoPizzas() {
        builder.setCreationStyle(PizzaBuilder.CreationStyle.PRECOMPUTED);
        Pizza pizza1 = builder.add(teig).add(sauce).build();
        Pizza pizza2 = builder.add(teig).add(sauce).add(sauce).build();

        assertEquals(List.of("Teig", "Tomatensauce"), pizza1.getIngredientNames());
        assertEquals(List.of("Teig", "Tomatensauce", "Tomatensauce"), pizza2.getIngredientNames());
    }

    @Test
    @DisplayName("can build a dynamically computed pizza with two ingredients")
    void buildAPizzaDynamically() {
        builder.setCreationStyle(PizzaBuilder.CreationStyle.DYNAMICALLY_COMPUTED);
        Pizza pizza = builder.add(teig).add(sauce).build();

        assertEquals(List.of("Teig", "Tomatensauce"), pizza.getIngredientNames());
        assertEquals(new BigDecimal("0.03"), pizza.calculatePrice());
        assertEquals(3000, pizza.calculateCalories());
    }

    @Test
    @DisplayName("can build two dynamically computed pizzas after another without mixing things up")
    void buildTwoPizzasDynamically() {
        builder.setCreationStyle(PizzaBuilder.CreationStyle.DYNAMICALLY_COMPUTED);
        Pizza pizza1 = builder.add(teig).add(sauce).build();
        Pizza pizza2 = builder.add(teig).add(sauce).add(sauce).build();

        assertEquals(List.of("Teig", "Tomatensauce"), pizza1.getIngredientNames());
        assertEquals(List.of("Teig", "Tomatensauce", "Tomatensauce"), pizza2.getIngredientNames());
    }

    @Test
    @DisplayName("a pizza should have at least two ingredients")
    void checkNumberOfIngredients() {
        assertThrows(IllegalPizzaException.class, builder::build);
        assertThrows(IllegalPizzaException.class, () -> builder.add(teig).build());
    }
}
