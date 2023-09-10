/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadtesting;

/**
 *
 * @author duyvu
 */
public class ThreadDemoDaemon {

    public static void main(String[] args) throws InterruptedException {
        // Thread and Its Property
        // - checking all of its properties those pre-defined methods
        Thread t3 = new ThreadExtendClass("HR Management");
        Thread t4 = new ThreadExtendClass("SendMail");

        System.out.println("ID: " + t3.threadId());
        System.out.println("Name: " + t3.getName());
        System.out.println("Priority: " + t3.getPriority());
        System.out.println("State: " + t3.getState());
        System.out.println("isAlive: " + t3.isAlive());

        System.out.println("========= RUNNING =========");
        System.out.println("Main thread running... ");

        // Interrupt the thread when it's sleep or wait
        // - If the thread is not sleep or wait, thread will be in normal behaviour but will set the flag interrupt = true
        t3.interrupt();

        // Daemon thread
        // - the daemon thread lives on the other threads
        // - If other threads are done, then the daemon thread done as well
        t4.setDaemon(true);

        t3.start();
        t4.start();

        Thread.sleep(2000);
        
        for(int i = 0; i < 1; i++) {
            System.out.println("MAINAAAAAAAAAAAAA: " + i);
        }
            
        System.out.println("Main thread stopped!!... ");

    }
}
