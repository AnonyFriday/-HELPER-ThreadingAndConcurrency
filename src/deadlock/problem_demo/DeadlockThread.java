package deadlock.problem_demo;

public class DeadlockThread implements Runnable {
    private Object obj1;
    private Object obj2;


    public DeadlockThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName(); // Get the name of current Thread
        System.out.println(name + " acquires lock on obj 1");

        synchronized (obj1) {
            System.out.println(name + " acquired lock on " + obj1);
            work();

            System.out.println(name + " accquiring lock on " + obj2);
            synchronized (obj2) {
                System.out.println(name + " acquired lock on " + obj2);
                work();
            }
        }

        System.out.println(name + " released lock on " + obj1);
        System.out.println(name + " finished execution.");
    }

    public void work() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
