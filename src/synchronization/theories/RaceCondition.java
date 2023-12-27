package synchronization.theories;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A condition that thread ordering is not guaranteed
 * -- Using putIfAbsent to avoid race condition
 * -- Using AtomicInteger to avoid data race
 */
public class RaceCondition {

    /**
     * Create a shared resource accessed by multiple threads
     * Still raising the race condition due to non-atomic operations
     */
    private static Map<String, String> pairs = new ConcurrentHashMap<>();

    /**
     * Create multiple thread adding new pair concurrently
     *
     * @param args
     */
    public static void main(String[] args) {

        ThreadGroup addToMapThreadGroup = new ThreadGroup("Add Thread Group");
        Thread t1 = new Thread(addToMapThreadGroup, () -> addToMap("Person", "Value_1"));
        Thread t2 = new Thread(addToMapThreadGroup, () -> addToMap("Animal", "Value_1"));
        Thread t3 = new Thread(addToMapThreadGroup, () -> addToMap("Person", "Value_3"));
        Thread t4 = new Thread(addToMapThreadGroup, () -> addToMap("Person", "Value_5"));
        Thread t5 = new Thread(addToMapThreadGroup, () -> addToMap("Animal", "Value_8"));
        Thread t6 = new Thread(addToMapThreadGroup, () -> addToMap("Person", "Value_9"));


        // Those thread will achieve the race condition when checking and writing happen in
        // no guaranteed order
        // ConcurrentHashMap still raise the same problem
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printMap();
    }


    /**
     * A function to demonstrate adding new key-value pair
     *
     * @param key
     * @param value
     */
    public static void addToMap(String key, String value) {
        for (int i = 0; i < 200; i++) {

            try {
                Thread.sleep(10);
                if (!pairs.containsKey(key)) {
                    pairs.put(key, value);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printMap() {
        pairs.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
