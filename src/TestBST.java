public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(1, "One");
        tree.put(4, "Four");

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}