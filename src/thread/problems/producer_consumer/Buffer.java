/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.producer_consumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author duyvu
 */
public class Buffer {

    // =============================
    // == Fields
    // =============================
    private int capacity;
    private List<Integer> products;

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
     * Add products to the list, attached with the product ID
     *
     * @param product
     * @param producerId
     */
    public void addProducts(int product,
                            int producerId) {
        System.out.println(">>>>--------------------------------------------------------");
        System.out.println("Producer " + producerId + " added a product " + product);
        products.add(product);
        System.out.println("On stock " + products.size() + "/" + capacity);
    }

    /**
     * Remove product from the list
     *
     * @param consumerId
     */
    public void removeProduct(int consumerId) {
        System.out.println("<<<<-------------------------------------------------------");
        System.out.println("Customer " + consumerId + " bought a product " + products.get(0));
        products.remove(0);
        System.out.println("On stock " + products.size() + "/" + capacity);
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
