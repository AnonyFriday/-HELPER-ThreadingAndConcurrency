/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronizationtesting.bankingexample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {

        MyBank myBank = new MyBank(100);
        List<WithdrawThread> withDrawnThreads = new ArrayList<>();

        // Create around 20 threads running on the same resources
        for (int i = 0; i < 100; i++) {
            withDrawnThreads.add(new WithdrawThread(myBank, Integer.toString(i)));
        }

        // Running 20 threads simultaneously
        for (WithdrawThread thread : withDrawnThreads) {
            thread.start();
        }

    }
}
