/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class implement runnable interfaces and being passed to the Thread constructor later on
 */
class ThreadInterface implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Thread TWO >> " + i);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/**
 * A thread implemented by extending the Thread class
 */
class ThreadClass extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Thread ONE >> " + i);
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class ThreadDeclaration {

    public static void main(String[] args) {
        // Intitialize the thread
        ThreadClass t1 = new ThreadClass();
        Thread t2 = new Thread(new ThreadInterface());
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Thread THREE >> " + i);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("Thread FOUR >> " + i);
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("MAIN THREAD >> " + i);
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Start all threads
        t4.start();
        t2.start();
        t1.start();
        t3.start();
    }
}
