package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.IngredientBuilder;

import java.util.*;

import static htw.berlin.wi.prog2.domain.Ingredient.Category.*;

// Eine statische Datenbank-Klasse
public class Menu {
    private Menu() {}
    private static Menu theInstance = null;

    public static Menu getInstance() {
        if(theInstance == null) theInstance = new Menu();
        return theInstance;
    }
    private IngredientBuilder builder = new IngredientBuilder();

    private Map<Long, Ingredient> articles = Map.of(
            1L, builder.setName("American-style").setPrice("0.60").setCals(120).build(BASE),
            2L, builder.setName("Italian-style").setPrice("0.70").setCals(100).build(BASE),
            3L, builder.setName("Schinken").setPrice("0.90").setCals(90).build(PROTEIN),
            4L, builder.setName("Seitan-Chicken").setPrice("0.90").setCals(80).build(PROTEIN),
            5L, builder.setName("Kirschtomaten").setPrice("0.40").setCals(20).build(TOPPING),
            6L, builder.setName("Champignons").setPrice("0.60").setCals(30).build(TOPPING),
            7L, builder.setName("Mozzarella").setPrice("0.60").setCals(40).build(TOPPING),
            8L, builder.setName("Basilikum").setPrice("0.30").setCals(20).build(TOPPING),
            9L, builder.setName("Tomatensauce").setPrice("0.30").setCals(40).build(SAUCE),
            10L, builder.setName("Olivenöl").setPrice("0.30").setCals(40).build(SAUCE));

    public Map<Long, Ingredient> getAllArticles() { return articles; }
}
