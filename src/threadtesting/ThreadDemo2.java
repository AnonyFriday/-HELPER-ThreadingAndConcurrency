/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadtesting;

/**
 *
 * @author duyvu
 */
public class ThreadDemo2 {

    public static void main(String[] args) {
        // Thread and Its Property
        // - checking all of its properties those pre-defined methods
        Thread t3 = new ThreadExtendClass("Thread 3");
        System.out.println("ID: " + t3.threadId());
        System.out.println("Name " + t3.getName());
        System.out.println("Priority " + t3.getPriority());
        System.out.println("State " + t3.getState());
        System.out.println("isAlive " + t3.isAlive());

        t3.start();

        // Setting the thread 
        t3.interrupt();

    }
}
