/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadtesting;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
public class ThreadDemoSleep {

    public static void exampleSleepMethod() {
        try {
            // The example demonstrates when setting Thread.sleep(2000), it does not mean sleeping in the exact 2000 ms, but a roughly number
            long start = System.currentTimeMillis();
            Thread.sleep(2000);
            System.out.println("Sleep time in ms = " + (System.currentTimeMillis() - start));
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadDemoSleep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        exampleSleepMethod();
    }
}
