/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronizationtesting.bankingexample;

import java.util.Random;

/**
 *
 * @author duyvu
 */
public class WithdrawThread extends Thread {
    
    private MyBank myBank;
    private String threadName;
    
    public WithdrawThread(MyBank myBank,
                          String threadName) {
        this.myBank = myBank;
        this.threadName = threadName;
    }
    
    @Override
    public void run() {

        // We gonna withdrawn 10 times per thread
        for (int i = 0; i < 200; i++) {
            myBank.withDraw(8, threadName);
        }
    }
}
