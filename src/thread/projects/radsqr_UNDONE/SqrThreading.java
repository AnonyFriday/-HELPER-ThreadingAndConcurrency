/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problems.radsqr_UNDONE;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
public class SqrThreading extends Thread {

    final SharedData rad;

    public SqrThreading(SharedData rad) {
	this.rad = rad;
    }

    public int sqrNum(int num) {
	return num * num;
    }

    /**
     * Apply synchronization to sqr number at different thread
     */
    @Override
    public void run() {
	for (int i = 0; i < 10; i++) {
	    try {
		Thread.sleep(200);
		int num = rad.getRad();
		System.out.println("Sqr: " + sqrNum(num));
	    } catch (InterruptedException ex) {
		Logger.getLogger(SqrThreading.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
}
