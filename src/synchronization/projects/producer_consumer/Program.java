/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.producer_consumer;

/**
 * @author duyvu
 */
public class Program {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);

        // Create 5 customer that automatically bought products from the buffer
        Consumer c1 = new Consumer(20, buffer);
        Consumer c2 = new Consumer(21, buffer);
        Consumer c3 = new Consumer(22, buffer);
        Consumer c4 = new Consumer(23, buffer);
        Consumer c5 = new Consumer(24, buffer);

        // Create 2 producer that automatically produce products to the buffer
        Producer p1 = new Producer(100, buffer);
        Producer p2 = new Producer(101, buffer);

        // start to produce
        p1.start();
        p2.start();

        // start to buy
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
