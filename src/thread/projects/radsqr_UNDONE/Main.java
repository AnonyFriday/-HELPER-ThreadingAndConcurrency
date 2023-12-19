/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problems.radsqr_UNDONE;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {

	// Share Object to be access amogst 2 threadsF
	SharedData rad = new SharedData();

	// Threads
	Thread radThread = new RadThreading(rad);
	Thread sqThread = new SqrThreading(rad);

	// Starting a thread
	radThread.start();
	sqThread.start();
    }
}
