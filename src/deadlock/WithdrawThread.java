/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deadlocktesting;

/**
 *
 * @author duyvu
 */
public class WithdrawThread extends Thread {

    Bank myBank;
    String threadName;

    public WithdrawThread(Bank myBank, String threadName) {
	this.myBank = myBank;
	this.threadName = threadName;
    }

    @Override
    public void run() {
	for (int i = 0; i < 10; i++) {
	    myBank.withDraw(200, threadName);
	}
    }
}
