package utils;

import java.net.URL;
import java.util.Date;

public class TestUtils {
    public static String generateRandomNumber() {
        Date date = new Date();
        return String.valueOf(Math.abs(date.hashCode()));
    }

    public static boolean isValidURL(String expectedUrl) {
        try {
            new URL(expectedUrl).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        //  System.out.println(Math.abs(generateRandomNumber()));
    }
}
