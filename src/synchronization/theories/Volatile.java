package synchronization.theories;


/**
 * Field Visibility
 * - core 1 has local cache and assigned with write thread
 * - core 2 has local cache and assigned with reader thread
 */
public class Volatile {

    /**
     * Without using the volatile keyword,
     * the thread toggle the 'active' wont
     * update value to main memory from CPU core cache
     */
    private volatile boolean active;

    public void prepare() throws InterruptedException {
        new Thread(() -> {
            System.out.println("application preparing ...");
            sleep(3);
            active = true;
        }).start();
    }

    public void start() throws Exception {
        new Thread(() -> {
            while (!active) ;
            System.out.println("application started");
        }).start();
    }

    private static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Field visibility issue
     * - Since the thread
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Volatile example = new Volatile();
        example.prepare();
        example.start();
        Thread.sleep(10);
    }
}
