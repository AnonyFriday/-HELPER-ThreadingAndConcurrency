/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories;

/**
 *
 * @author duyvu
 */
class ThreadDemo2 extends Thread {

    @Override
    public void run() {
	for (int i = 0; i < 100; i++) {
	    System.out.println("This thread extends Thread class");
	}
    }
}

public class ThreadStart {

    public static void main(String[] args) {

	/**
	 * Thread passing Runnable functional Interface through the constructor
	 */
	Thread t1 = new Thread(new Runnable() {
	    @Override
	    public void run() {
		for (int i = 0; i < 1000; i++) {
		    System.out.println("a");
		}
	    }
	});
	t1.start();

	// Main thread
	for (int i = 0; i < 1000; i++) {
	    System.out.println("MAIN THREAD: " + i);
	}

	/**
	 * Create seperate Runnable Object and pass it through the Thread Contructor
	 */
	Runnable runnable = new Runnable() {
	    @Override
	    public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " running");
	    }
	};

	Thread t2 = new Thread(runnable);

	/**
	 * This class extends ad thread and override the run() method
	 */
	ThreadDemo2 threadDemo2 = new ThreadDemo2();

	/**
	 * This thread does not have reference but still having an instance of it
	 */
	new Thread(new Runnable() {
	    @Override
	    public void run() {
		for (int i = 0; i < 100; i++) {
		    System.out.println("No reference has been created");
		}
	    }
	}).start();

	threadDemo2.start();
	t1.start();
	t2.start();
    }
}
