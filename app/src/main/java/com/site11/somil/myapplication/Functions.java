package com.site11.somil.myapplication;

/**
 * Created by somil on 6/6/15.
 */
public class Functions {

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
