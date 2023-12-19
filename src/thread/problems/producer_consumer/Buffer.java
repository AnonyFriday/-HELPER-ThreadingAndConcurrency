/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.producer_consumer;

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
            if (products.size() == this.capacity) {
                System.out.println("The storage is full. Stop Producing, waiting ...");

                // if the storage is full, add the thread holding this monitor into wait set
                products.wait();
            }

            Thread.sleep(2000);

            System.out.println(">>>>--------------------------------------------------------");
            System.out.println("Producer " + producerId + " added a product " + product);
            products.add(product);
            System.out.println("On stock " + products.size() + "/" + capacity);

            // After added a product, notify all waited threads fighting together for the monitory
            if (this.products.size() == 1) {
                products.notifyAll();
            }
        }
    }

    /**
     * Remove product from the list
     *
     * @param consumerId
     */
    public void removeProduct(int consumerId) throws InterruptedException {

        synchronized (products) {
            if (products.isEmpty()) {
                System.out.println("The storage is empty. Wait to add more ...");
                notifyAll();
            }

//            Thread.sleep(1000);

            System.out.println("<<<<-------------------------------------------------------");
            System.out.println("Customer " + consumerId + " bought a product " + products.peek());
            products.remove();
            System.out.println("On stock " + products.size() + "/" + capacity);

            // After bought a product, a thread goes to the wait set for the next execution
            if (products.size() == this.capacity - 1) {
                wait();
            }
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
