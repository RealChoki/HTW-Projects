package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuUtils {

    public static List<String> focusOnNames(Map<Long, Ingredient> articles) {
        List<String> names = new ArrayList<>();
        for (Ingredient art : articles.values()) names.add(art.getName());
        return names;
    }

    public static Map<String, Long> focusOnNameAndInvert(Map<Long, Ingredient> articles) {
        return articles.entrySet().stream().collect(Collectors.toMap(
                (entry) -> entry.getValue().getName(), (entry) -> entry.getKey()
        ));
    }

    public static List<Ingredient> ingredientsFromIdAndCount(Map<Long, Integer> idsAndCount, Map<Long, Ingredient> articles) {
        List<Ingredient> result = new ArrayList<>();
        for(Map.Entry<Long, Integer> entry : idsAndCount.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                result.add(articles.get(entry.getKey()));
            }
        }
        return result;
    }
}
