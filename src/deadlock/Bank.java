/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deadlocktesting;

/**
 *
 * @author duyvu
 */
public class Bank {

    int money;

    // Default Constructor
    public Bank() {
    }

    // Parameterized Constructor
    public Bank(int money) {
	this.money = money;
    }

    // Getters & Setters
    public int getMoney() {
	return money;
    }

    public void setMoney(int money) {
	this.money = money;
    }

    public synchronized void withDraw(int money, String threadName) {
	if (money <= this.money) {
	    System.out.println("Withdrawn: " + money + ">>" + threadName);
	    this.money -= money;
	} else {
	    System.out.println("The withdrawn has been exceeding the current balance.");
	}
	System.out.println("Current: " + this.money);
    }
}
