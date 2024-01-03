package htw.berlin.wi.prog2.parsing;

import java.util.Map;

public interface ExtendableInputParser {
    Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds);
}
