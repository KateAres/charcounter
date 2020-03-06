package ua.com.foxminded.charcounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CachedSymbolsCounterTest {

    @Test
    void countSymbolsShouldReturnCachedResultWhenItHasSameCachedString() {
        CachedSymbolsCounter cachedSymbolsCounter = new CachedSymbolsCounter();
        String firstActualResult = cachedSymbolsCounter.countSymbols("Magical");
        String secondActualResult = cachedSymbolsCounter.countSymbols("Magical");
        assertSame(firstActualResult, secondActualResult);
    }

    @Test
    void countSymbolsShouldReturnGivenColumnWhenItGetsStringWithSpaceAndExclamationMark() {
        CachedSymbolsCounter cachedSymbolsCounter = new CachedSymbolsCounter();
        String actual = cachedSymbolsCounter.countSymbols("hello world!");
        String expected = "hello world!" + "\n"
                + "\"h\" - 1" + "\n"
                + "\"e\" - 1" + "\n"
                + "\"l\" - 3" + "\n"
                + "\"o\" - 2" + "\n"
                + "\" \" - 1" + "\n"
                + "\"w\" - 1" + "\n"
                + "\"r\" - 1" + "\n"
                + "\"d\" - 1" + "\n"
                + "\"!\" - 1" + "\n";
        assertEquals(expected, actual);
    }

    @Test
    void countSymbolsShouldReturnGivenColumnWhenItGetsStringWithSeveralSpacesAtEnd() {
        CachedSymbolsCounter cachedSymbolsCounter = new CachedSymbolsCounter();
        String actual = cachedSymbolsCounter.countSymbols("hello       ");
        String expected = "hello       " + "\n"
                + "\"h\" - 1" + "\n"
                + "\"e\" - 1" + "\n"
                + "\"l\" - 2" + "\n"
                + "\"o\" - 1" + "\n"
                + "\" \" - 7" + "\n";
        assertEquals(expected, actual);
    }

    @Test
    void countSymbolsShouldReturnGivenColumnWhenItGetsStringWithSeveralSpacesAtBeginning() {
        CachedSymbolsCounter cachedSymbolsCounter = new CachedSymbolsCounter();
        String actual = cachedSymbolsCounter.countSymbols("    getting");
        String expected = "    getting" + "\n"
                + "\" \" - 4" + "\n"
                + "\"g\" - 2" + "\n"
                + "\"e\" - 1" + "\n"
                + "\"t\" - 2" + "\n"
                + "\"i\" - 1" + "\n"
                + "\"n\" - 1" + "\n";
        assertEquals(expected, actual);
    }

    @Test
    void countSymbolsShouldReturnGivenColumnWhenItGetsStringWithSeveralDotsAndMedialSpaces() {
        CachedSymbolsCounter cachedSymbolsCounter = new CachedSymbolsCounter();
        String actual = cachedSymbolsCounter.countSymbols("....            rfr....");
        String expected = "....            rfr...." + "\n"
                + "\".\" - 8" + "\n"
                + "\" \" - 12" + "\n"
                + "\"r\" - 2" + "\n"
                + "\"f\" - 1" + "\n";
        assertEquals(expected, actual);
    }

    @Test
    void countSymbolsShouldReturnGivenColumnWhenItGetsStringWithSeveralSpecialCharacters() {
        CachedSymbolsCounter cachedSymbolsCounter = new CachedSymbolsCounter();
        String actual = cachedSymbolsCounter.countSymbols("@&777* rfr..)(((0");
        String expected = "@&777* rfr..)(((0" + "\n"
                + "\"@\" - 1" + "\n"
                + "\"&\" - 1" + "\n"
                + "\"7\" - 3" + "\n"
                + "\"*\" - 1" + "\n"
                + "\" \" - 1" + "\n"
                + "\"r\" - 2" + "\n"
                + "\"f\" - 1" + "\n"
                + "\".\" - 2" + "\n"
                + "\")\" - 1" + "\n"
                + "\"(\" - 3" + "\n"
                + "\"0\" - 1" + "\n";
        assertEquals(expected, actual);
    }
}
