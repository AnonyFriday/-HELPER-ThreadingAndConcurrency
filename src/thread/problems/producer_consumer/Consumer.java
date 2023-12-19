/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.producer_consumer;

import static java.lang.Thread.sleep;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duyvu
 */
public class Consumer extends Thread {

    private int id;
    private Buffer buffer;

    public Consumer(int id,
                    Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        // Automatically take the product from the buffer continuously
        while (true) {
            try {
                buffer.removeProduct(id);
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }
    }

}
