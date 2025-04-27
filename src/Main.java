import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(100);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            String name = generateRandomString(5, random);
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student(name, 18 + random.nextInt(5));
            table.put(key, value);
        }

        for (int i = 0; i < table.getNumberOfBuckets(); i++) {
            int count = table.getBucket(i).size();
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }

    private static String generateRandomString(int length, Random rand) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return sb.toString();
    }
}