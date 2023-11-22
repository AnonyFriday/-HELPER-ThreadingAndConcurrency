/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.producer_consumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
public class Producer extends Thread {

    private int id;
    private Buffer buffer;

    public Producer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    /**
     * Override Run methods
     */
    @Override
    public void run() {
        // Demonstrate the product's content
        int i = 0;

        // Product products
        while (true) {
            // If the storage has available slots
            if (buffer.getCapacity() > buffer.getSize()) {
                try {
                    buffer.addProducts(i++, id);
                    Producer.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
