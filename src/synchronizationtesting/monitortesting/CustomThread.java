/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronizationtesting.monitortesting;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
class MyData {

    // Attributes
    private String name;

    // Constructor
    public MyData(String name) {
        this.name = name;
    }

    /**
     * Displaying each character with in the passed string
     *
     * <br>A demonstration of accessing the shared object from multithreading
     * <br>This is a critical region (a block of code that make deadlock)
     *
     * @throws InterruptedException
     */
    public void display() throws InterruptedException {

        synchronized (this) {
            for (char el : this.name.toCharArray()) {
            Thread.sleep(1001);
                System.out.print(el);
            }
        }
    }
}

public class CustomThread extends Thread {

    private String threadName;
    private MyData data;

    /**
     * A custom constructor assigned with the data and the thread name
     *
     * @param data
     * @param threadName
     */
    public CustomThread(MyData data,
                        String threadName) {
        this.threadName = threadName;
        this.data = data;
    }

    /**
     * Running the custom block of code to observer the thread
     *
     */
    @Override
    public void run() {
        System.out.print("Thread " + this.threadName + ": ");
        try {
            data.display(); // 2 pointer accessing the same object DATA and call the method display() simultaneously
        } catch (InterruptedException ex) {
            Logger.getLogger(CustomThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\n");
    }
}
