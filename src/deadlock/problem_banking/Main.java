/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deadlock.problem_banking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
	Bank myBank = new Bank(1000);

	// Sequence Handling
//	myBank.withDraw(200, "T0");
//	myBank.withDraw(300, "T1");
//	myBank.withDraw(100, "T2");
	// Deadlock Demonstration (race condition)
	// - Assuming that multiple thread withdrawn money the bank at the same tie
	// - When starting thread, it start running independently, not sequencing handling
	List<WithdrawThread> threadList = new ArrayList<>();

	// Add around 100 threads withdrawing money into a list
	// Each thread calls a  withdraw method 10 times
	// - If no synchronization, all thread will access the same shared object, 
	// deduct the whole money of the bank without any stop condtion even we have condtion 
	// to stop withdrawing money (result in negative money)
	for (int i = 0; i < 100; i++) {
	    threadList.add(new WithdrawThread(myBank, "T" + i));
	}

	// Starting each thread independently
	for (WithdrawThread thread : threadList) {
	    thread.start();
	}
    }
}
