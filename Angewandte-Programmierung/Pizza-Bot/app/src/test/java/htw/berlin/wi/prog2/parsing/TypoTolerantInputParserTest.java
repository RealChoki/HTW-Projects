package htw.berlin.wi.prog2.parsing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypoTolerantInputParserTest {

    private final TypoTolerantInputParser sut = new TypoTolerantInputParser();

    @Test
    @DisplayName("can make use of the provided different spellings or common typos")
    void idsAndCountFromInput() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne eine Italian-Style Pizza mit Mozarela, SChinken und nochmal Shcinken";
        Map<String, Long> keywordsToIds = Map.of(
                "Italian-Style", 19L,
                "Italian-style", 19L,
                "Italianstyle", 19L,
                "Mozzarella", 87L,
                "Mozarrela", 87L,
                "Mozzarela", 87L,
                "Mozarela", 87L,
                "Schinken", 77L,
                "Shcinken", 77L,
                "SChinken", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 1,
                77L, 2);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }
}
