/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problems.radsqr_UNDONE;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Taking the rad number concurrently from the rad as the store
 *
 * @author duyvu
 */
public class RadThreading extends Thread {

    private final SharedData rad;

    public RadThreading(SharedData rad) {
	this.rad = rad;
    }

    /**
     * Apply synchronization to sequentially access the storage At this example, only rad is the shared reference, only
     * 1 thread is allowed to access at the time
     */
    @Override
    public void run() {
	for (int i = 0; i < 10; i++) {

	    Random rand = new Random();
	    int randDouble = rand.nextInt(0, 10);
	    rad.setRad(randDouble);

	    // print out the random double number
	    System.out.println("Num: " + randDouble);

	}
    }
}
