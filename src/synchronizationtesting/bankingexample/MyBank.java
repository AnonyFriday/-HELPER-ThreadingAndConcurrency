/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronizationtesting.bankingexample;

/**
 *
 * @author duyvu
 */
public class MyBank {

    // Attributes
    private int money;

    // Constructor
    public MyBank() {
    }

    public MyBank(int money) {
        this.money = money;
    }

    /**
     *
     * A synchronized method to let 1 thread completely entire the withdrawn method before letting the next thread to continue
     *
     * @param money
     * @param threadName
     */
    public synchronized void withDraw(int money,
                                      String threadName) {
        if (money <= this.money) {
            System.out.println("Withdrawn: " + money + ", Remainning: " + this.money + " from thread: " + threadName);
            this.money -= money;
        } else {
            System.out.println("EXCEED!");
        }

        System.out.println("Balance: " + this.money);
    }

    // Getters & Setters
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
