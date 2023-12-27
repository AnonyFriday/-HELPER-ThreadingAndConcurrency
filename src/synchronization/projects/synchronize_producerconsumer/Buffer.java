/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.projects.synchronize_producerconsumer;

import java.util.*;

/**
 * @author duyvu
 */
public class Buffer {

    // =============================
    // == Fields
    // =============================
    private int capacity;
    private final Queue<Integer> products;

    // =============================
    // == Constructor 
    // =============================
    public Buffer(int capacity) {
        this.capacity = capacity;
        products = new LinkedList<>();
    }

    // =============================
    // == Methods
    // =============================

    /**
     * Push product to the queue, attached with the product ID
     *
     * @param product
     * @param producerId
     */
    public void addProduct(int product,
                           int producerId) throws InterruptedException {

        synchronized (products) {
            while (products.size() == this.capacity) {
                System.out.println("The storage is full. Stop Producing, waiting ...");

                // if the storage is full, add the thread holding this monitor into wait set
                products.wait();
            }

            // Simulate the production time
            Thread.sleep(100);

            System.out.println(">>>>--------------------------------------------------------");
            System.out.println("Producer " + producerId + " added a product " + product);
            products.add(product);
            System.out.println("On stock " + products.size() + "/" + capacity);


            // After added a product, notify all waited threads fighting together for the monitory
            products.notifyAll();
        }
    }

    /**
     * Remove product from the list
     *
     * @param consumerId
     */
    public void removeProduct(int consumerId) throws InterruptedException {
        synchronized (products) {

            // Using while instead of when the thread acquire the lock
            // using while => If accquired, but queue is empty then keep waiting
            // using if => If accquired, jump out the if statement and remove => deduction will be overflow
            while (products.isEmpty()) {
                System.out.println("The storage is empty. Wait to add more ...");

                products.wait();
                // Thread will be blocked here, and be allocated at waiting set
            }

            // Simulate the consumption time
            Thread.sleep(100);

            System.out.println("<<<<-------------------------------------------------------");
            System.out.println("Customer " + consumerId + " bought a product " + products.peek());
            products.remove();
            System.out.println("On stock " + products.size() + "/" + capacity);

            // After bought a product, a thread goes to the wait set for the next execution
            products.notifyAll();
        }
    }

    // =============================
    // == Getters & Setters
    // =============================
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return this.products.size();
    }
}
