package utils;

import java.util.Random;

public class RandomNameGenerator {
    private static final Random random = new Random();

    public static String generateRandomFirstname() {
        String[] firstNames = {"John", "Jane", "Alex", "Emily", "Chris", "Katie", "Michael", "Sarah"};
        String firstName = firstNames[random.nextInt(firstNames.length)];
        return firstName;
    }
    public static String generateRandomLastname() {
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis"};
        String lastName = lastNames[random.nextInt(lastNames.length)];
        return lastName;
    }
}
