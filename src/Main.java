import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(100); // 100 buckets
        Random random = new Random();

        // Add 10,000 random elements
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000); // random id
            String name = generateRandomString(5); // random 5-letter name
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student(name, 18 + random.nextInt(5)); // age between 18-22
            table.put(key, value);
        }

        // Print number of elements in each bucket
        for (int i = 0; i < table.getNumberOfBuckets(); i++) {
            int count = table.getBucket(i).size();
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }

    // Helper method to generate random strings
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return sb.toString();
    }
}