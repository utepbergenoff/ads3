import java.util.Random;

public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        for (char c : name.toCharArray()) {
            hash = 31 * hash + c;
        }
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTestingClass that = (MyTestingClass) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public String toString() {
        return "(" + id + ", " + name + ")";
    }
}