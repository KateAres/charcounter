package ua.com.foxminded.charcounter;

import java.util.Scanner;

public class InputService {

    public static String inputLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type Line: ");
        return scanner.nextLine();
    }
}
