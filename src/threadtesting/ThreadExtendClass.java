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
public class ThreadExtendClass extends Thread {

    public ThreadExtendClass(String name) {
        super(name);
        setPriority(Thread.MAX_PRIORITY);
    }

    /** Setting a body of thread within a run method
     *
     */
    @Override
    public void run() {
        int count = 1;
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println(this.getName() + ", " + i);

                // Let the thread sleep for a while
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println(this.getName() + " exiting.");
        }
    }
}