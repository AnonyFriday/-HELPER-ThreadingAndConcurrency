/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.producer_consumer;

import java.util.ArrayList;

/**
 *
 * @author duyvu
 */
public class Buffer {

    // =============================
    // == Fields
    // =============================
    private int capacity;
    private ArrayList<Integer> products = new ArrayList<>();

    // =============================
    // == Methods
    // =============================
    public void addProducts(int product, int producerId) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Produceer " + producerId + " added product " + product);
        products.add(product);
        System.out.println("In Stock: " + products.size());
    }

    public void removeProduct(int consumerId) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Consumer " + consumerId + " has bought the product " + products.get(0));
        products.remove(0);
    }
}
