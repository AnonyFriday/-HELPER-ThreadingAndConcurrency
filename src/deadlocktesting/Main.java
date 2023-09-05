/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deadlocktesting;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {
        Bank myBank = new Bank(1000);

        // Sequence Handling
//	myBank.withDraw(200, "T0");
//	myBank.withDraw(300, "T1");
//	myBank.withDraw(100, "T2");
        // Deadlock Demonstration (race condition)
        // - Assuming that multiple thread withdrawn money the bank at the same tie
        // - When starting thread, it start run concurreny, not sequencing handling
        List<WithdrawThread> threadList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            threadList.add(new WithdrawThread(myBank, "T" + i));

        }

        for (WithdrawThread thread : threadList) {
            thread.start();
        }
    }
}
