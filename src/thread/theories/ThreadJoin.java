/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class implement runnable interfaces and being passed to the Thread constructor later on
 */
class ThreadRunnable implements Runnable {

    // Declare the t1 to let it calling join() at t2's run()
    ThreadClass t1 = null;

    // Constructor
    public ThreadRunnable(ThreadClass t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread TWO is running");
            System.out.println("t1 JOINING the Thread TWO");

            // Provide only 500 ms to execute the t1, after that join will back the control to t2
            // both t1 and t2 will run independently after 500ms
            t1.join(500);

            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Thread TWO >> " + i);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("t2 is finished");
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/**
 * A thread implemented by extending the Thread class
 */
class ThreadClass extends Thread {

    /**
     * Apply the code in run() threading function
     */
    @Override
    public void run() {
        setName("Thread Class");
        System.out.println(Thread.currentThread().getName() + " is running");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ">>>>" + i);
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(Thread.currentThread().getName() + " is finished");
    }
}

/**
 *
 * @author duyvu
 */
public class ThreadJoin {

    public static void main(String[] args) {
        ThreadClass t1 = new ThreadClass();
        Thread t2 = new Thread(new ThreadRunnable(t1));
        t2.setName("Thread Two");

        t2.start();
        t1.start();

    }
}
