/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadtesting;

import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("\nStart Thread: " + t.getName());

        // Simulate the thread's task
        for (int i = 0; i < 50; i++) {
            System.out.println(t.getName() + " " + i + " ");
        }

        System.out.println("\nEnd Thread: " + t.getName());
    }

}

/** What is Join Thread
 *
 * When the running thread forces the other to wait for its running
 *
 * Comply with the order of running state as expected
 *
 * @author duyvu
 */
public class ThreadDemoJoin {

    // Assuming the thread will start and end in order 1 > 2 > 3
    // But life is tough 
    public static void exampleThreadsWithoutJoin() {
        Thread th1 = new Thread(new MyThread(), "th1");
        Thread th2 = new Thread(new MyThread(), "th2");
        Thread th3 = new Thread(new MyThread(), "th3");
        th1.start();
        th2.start();
        th3.start();
    }

    public static void exampleThreadsWithJoin() {
        Thread th1 = new Thread(new MyThread(), "th1");
        Thread th2 = new Thread(new MyThread(), "th2");
        Thread th3 = new Thread(new MyThread(), "th3");
        Thread th4 = new Thread(new MyThread(), "th4");
        Thread th5 = new Thread(new MyThread(), "th5");

        // th2, th4 are not affected since the th1 will join() later, not this time
        // th2, th4 will run seperately
        th2.start();
        th4.start();
        th1.start();    // Run thread 1

        // The other threads beneath the calling join() have to wait for th1's termination
        // th3, th5 have to wait th1 since calling join() at first of starting th3 and th5
        try {
            System.out.println("START Processing thread 1. Please wait!");
            th1.join(1000);
            System.out.println("END Processing thread 1. Please wait!");
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadDemoJoin.class.getName()).log(Level.SEVERE, null, ex);
        }

        th3.start();
        th5.start();
    }

    public static void main(String[] args) {
//        exampleThreadsWithoutJoin();
        exampleThreadsWithJoin();
    }
}
