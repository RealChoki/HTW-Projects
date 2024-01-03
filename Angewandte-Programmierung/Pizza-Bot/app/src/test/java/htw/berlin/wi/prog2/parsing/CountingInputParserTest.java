package htw.berlin.wi.prog2.parsing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountingInputParserTest {

    private final CountingInputParser sut = new CountingInputParser();

    @Test
    @DisplayName("can detect multiple occurrences of ingredients")
    void testCounting() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne eine American-style Pizza mit Mozzarella Mozzarella und noch mehr Mozzarella";
        Map<String, Long> keywordsToIds = Map.of(
                "American-style", 19L,
                "Mozzarella", 87L,
                "Schinken", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 3);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("can deal with commas and dots")
    void testCommaAndDot() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne eine American-style Pizza mit Mozzarella, Mozzarella, und noch mehr Mozzarella.";
        Map<String, Long> keywordsToIds = Map.of(
                "American-style", 19L,
                "Mozzarella", 87L,
                "Schinken", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 3);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }
}
