/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.producer_consumer;

import static java.lang.Thread.sleep;

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
                buffer.addProduct(i++, this.id);
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }
    }
}
