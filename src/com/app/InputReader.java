package com.app;

import java.util.Scanner;

public final class InputReader {

    private InputReader() {
    }

    public static DeliveryMode readDeliveryMode(Scanner scanner, String argument) {
        String raw = valueOrPrompt(scanner, argument, "Enter delivery mode (ROAD/SEA): ");
        if (raw == null) {
            System.out.println("No delivery mode provided. Stopping.");
            return null;
        }
        try {
            return DeliveryMode.valueOf(raw.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Unsupported delivery mode: '" + raw + "'. Supported values: ROAD, SEA.");
            return null;
        }
    }

    public static UIPlatform readUIPlatform(Scanner scanner, String argument) {
        String raw = valueOrPrompt(scanner, argument, "Enter UI platform (WINDOWS/MACOS): ");
        if (raw == null) {
            System.out.println("No UI platform provided. Stopping.");
            return null;
        }
        try {
            return UIPlatform.valueOf(raw.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Unsupported UI platform: '" + raw + "'. Supported values: WINDOWS, MACOS.");
            return null;
        }
    }

    private static String valueOrPrompt(Scanner scanner, String argument, String prompt) {
        if (argument != null && !argument.isBlank()) {
            return argument;
        }
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            return null;
        }
        String line = scanner.nextLine();
        return line.isBlank() ? null : line;
    }
}