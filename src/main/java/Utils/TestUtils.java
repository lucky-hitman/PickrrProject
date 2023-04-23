package Utils;

import java.util.Date;

public class TestUtils {
    public static String generateRandomNumber() {
        Date date = new Date();
        return String.valueOf(Math.abs(date.hashCode()));
    }

    public static void main(String[] args) {
      //  System.out.println(Math.abs(generateRandomNumber()));
    }
}
