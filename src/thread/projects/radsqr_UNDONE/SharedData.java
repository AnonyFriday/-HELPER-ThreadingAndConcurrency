/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problems.radsqr_UNDONE;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generating the random number and being accessed by the radThread
 *
 * @author duyvu
 */
public class SharedData {

    int rad;

    public int getRad() {
	synchronized (this) {
	    try {
		Thread.sleep(100);
		this.wait();
	    } catch (InterruptedException ex) {
		Logger.getLogger(SharedData.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    return rad;
	}
    }

    public void setRad(int rad) {
	synchronized (this) {
	    this.rad = rad;
	    this.notifyAll();
	}
    }
}
