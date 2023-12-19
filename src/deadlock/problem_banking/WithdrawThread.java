/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deadlock.problem_banking;

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

    // A thread will run the withdrawn money 10 times independenly 
    @Override
    public void run() {
	for (int i = 0; i < 5; i++) {
	    myBank.withDraw(20, threadName);
	}
    }
}
