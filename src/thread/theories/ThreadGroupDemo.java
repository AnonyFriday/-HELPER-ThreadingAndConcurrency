/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories;

/**
 *
 * @author duyvu
 */
public class ThreadGroupDemo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadGroupDemo runnable = new ThreadGroupDemo();
        ThreadGroup grp1 = new ThreadGroup("Parent ThreadGroup");

        Thread t1 = new Thread(grp1, runnable, "one");
        Thread t2 = new Thread(grp1, runnable, "two");
        Thread t3 = new Thread(grp1, runnable, "three");

        t1.start();
        t2.start();
        t3.start();
        
        // All functions of threadgroup
        grp1.activeCount();
    }
}
