package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;

public class CachedSymbolsCounter {

    private final Map<String, String> cache = new HashMap<>();

    public String countSymbols(String inputLine) {
        String result;
        if (cache.containsKey(inputLine)) {
            result = cache.get(inputLine);
        } else {
            result = countUniqueElements(inputLine);
            cache.put(inputLine, result);
        }
        return result;
    }

    private int countChars(char currentChar, String inputLine) {
        return (int) inputLine.chars()
                .filter(c -> c == currentChar)
                .count();
    }

    private String countUniqueElements(String inputLine) {
        StringBuilder result = new StringBuilder();
        String uniqueCharsLine = removeRepeatedChars(inputLine);
        result.append(inputLine).append("\n");
        for (int i = 0; i < uniqueCharsLine.length(); i++) {
            result.append("\"").append(uniqueCharsLine.charAt(i)).append("\"")
                    .append(" - ").append(countChars(uniqueCharsLine.charAt(i), inputLine)).append("\n");
        }
        return result.toString();
    }

    private String removeRepeatedChars(String inputLine) {
        return inputLine.chars().distinct().collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
