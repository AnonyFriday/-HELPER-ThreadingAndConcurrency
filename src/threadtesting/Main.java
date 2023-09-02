/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadtesting;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {

	// Background Thread 1
	Thread t1 = new Thread(new Runnable() {
	    @Override
	    public void run() {
		for (int i = 0; i < 1000; i++) {
		    System.out.println("Thread 1: " + i);
		}
	    }
	});
	t1.start();

//        // Main Thread
//        for (int i = 0; i < 1000; i++) {
//            System.out.println("MAIN THREAD: " + i);
//        }
//        // Background Thread 2
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    System.out.println("Thread 2: " + i);
//                }
//            }
//        });
//        t2.start();
	// Background Thread 3
	Thread t3 = new ThreadExtendClass();
	t3.start();
    }
}
