package ua.com.foxminded.charcounter;

public class Main {
    public static void main(String[] args) {
        CachedSymbolsCounter cachedSymbolsCounter = new CachedSymbolsCounter();
        System.out.println(cachedSymbolsCounter.countSymbols(InputService.inputLine()));
    }
}
