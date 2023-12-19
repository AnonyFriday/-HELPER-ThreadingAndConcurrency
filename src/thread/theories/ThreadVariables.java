/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
public class ThreadVariables {

    /**
     * Create the custom thread implementing the Runnable interface
     */
    public static class MyThread implements Runnable {

        // Variable to set the timout of 1 thread
        private int numberOfSeconds;

        // Constructor
        public MyThread(int numberOfSeconds) {
            this.numberOfSeconds = numberOfSeconds;
        }

        @Override
        public void run() {
            // Let the thread run upto timeout, and sleep in 1s
            for (int i = 0; i < this.numberOfSeconds; i++) {
                try {
                    System.out.println("Sleeping 1s: " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadDaemon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Main function for testing
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(100), "---T1");
        Thread t2 = new Thread(new MyThread(5), "T2");

        // Daemon will stop immediately even having 100s timeout > 5s timeout
        t1.setDaemon(true);

        t1.start();
        t2.start();
    }
}
