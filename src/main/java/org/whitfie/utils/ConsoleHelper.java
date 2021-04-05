package org.whitfie.utils;

import java.util.Scanner;

public class ConsoleHelper {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) { }
        return 0;
    }


    public static void printTranslateSource() {
        System.out.println("1 - WOORDHUNT");
        System.out.println("2 - BABLA");
    }

    public static void printCommands() {
        System.out.println("1 - EXIT");
        System.out.println("2 - READ");
        System.out.println("3 - SAVE");
        System.out.println("4 - PRINT");
        System.out.println("5 - TRANSLATE");
    }
    public static void printTypeForRead() {
        System.out.println("exist format type:");
        System.out.println("Txt");
        System.out.println("Docs");
    }

    public static void printTypeForSave() {
        System.out.println("exist format type:");
        System.out.println("Txt");
        System.out.println("Docs");
        System.out.println("json");
    }
}
