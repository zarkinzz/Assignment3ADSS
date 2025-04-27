import models.MyHashTable;
import test.MyTestingClass;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(i, "Name" + i), "Student" + i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Insertion time: " + (end - start) + "ms");

        int found = 0;
        for (int i = 0; i < 10000; i++) {
            if (table.get(new MyTestingClass(i, "Name" + i)) != null) {
                found++;
            }
        }

        System.out.println("Found: " + found + " / 10000");
    }
}
