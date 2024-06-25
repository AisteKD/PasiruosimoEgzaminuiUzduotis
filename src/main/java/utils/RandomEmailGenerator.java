package utils;

import java.util.Random;

public class RandomEmailGenerator {

    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        while (email.length() < 10) {
            int index = random.nextInt(characters.length());
            email.append(characters.charAt(index));
        }
        email.append("@example.com");
        return email.toString();
    }
}
