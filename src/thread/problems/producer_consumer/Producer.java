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
public class Producer extends Thread {

    private int id;
    private Buffer buffer;

    public Producer(int id,
                    Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // automatically generete product at the random time
        int i = 0;
        while (true) {
            try {
                if (buffer.getCapacity() > buffer.getSize()) {
                    buffer.addProducts(i++, this.id);
                    Thread.sleep((long) (Math.random() * 1000));
                }
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }

    }
}
