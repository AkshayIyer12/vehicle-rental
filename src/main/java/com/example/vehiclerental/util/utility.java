package com.example.vehiclerental.util;

public class utility {
    public static void log(String input) {
        System.out.println(input);
    }

    public static boolean isEmpty(String input) {
        return input == null || input.length() == 0;
    }

    public static boolean isNotEmpty(String input) {
        return !isEmpty(input);
    }
}
