package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.IngredientBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static htw.berlin.wi.prog2.domain.Ingredient.Category.*;
import static org.junit.jupiter.api.Assertions.*;

class MenuUtilsTest {

    private final IngredientBuilder builder = new IngredientBuilder();
    private final Ingredient champignons = builder.setName("Champignons").setPrice("0.01").setCals(1000).build(TOPPING);
    private final Ingredient mozzarella = builder.setName("Mozzarella").setPrice("0.02").setCals(2000).build(TOPPING);
    private final Ingredient schinken = builder.setName("Schinken").setPrice("0.03").setCals(3000).build(PROTEIN);

    private final Map<Long, Ingredient> testMenu = Map.of(
            42L, champignons,
            66L, mozzarella,
            17L, schinken);

    @Test
    @DisplayName("should extract only the ingredient names from the Menu")
    void focusOnNames() {
        List<String> expected = List.of("Champignons", "Mozzarella", "Schinken");
        List<String> actual = MenuUtils.focusOnNames(testMenu);

        List<String> expectedSorted = expected.stream().sorted().collect(Collectors.toList());
        List<String> actualSorted = actual.stream().sorted().collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    @DisplayName("should select the ingredient name and invert the passed map, i.e. keys become values and values become keys")
    void focusOnNameAndInvert() {
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(testMenu);
        Map<String, Long> expected = Map.of(
                "Champignons", 42L,
                "Mozzarella", 66L,
                "Schinken", 17L);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should get the ingredients from the passed menu in the stated quantities of the input map")
    void ingredientsFromIdAndCount() {
        Map<Long, Integer> counts = Map.of(
                66L, 1,
                17L, 2);

        List<Ingredient> expected = List.of(mozzarella, schinken, schinken);
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(counts, testMenu);

        Comparator<Ingredient> byName = Comparator.comparing(Ingredient::getName);
        List<Ingredient> expectedSorted = expected.stream().sorted(byName).collect(Collectors.toList());
        List<Ingredient> actualSorted = actual.stream().sorted(byName).collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }
}
