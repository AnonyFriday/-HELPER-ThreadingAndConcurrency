/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronizationtesting.monitortesting;

/**
 * The
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Accessing the same shared data
        MyData data = new MyData("Hello World MY NAME IS CHIKICUCUC");
        System.out.println("MAIN THREAD START");

        // 2 threads try to read the same shared data
        // - Without Synchronization, the data has been scramble due to the running individually of the thread
        CustomThread thread_1 = new CustomThread(data, "1");
        CustomThread thread_2 = new CustomThread(data, "2");

        thread_1.start();
        thread_2.start();

        // The mainthread runs independably
        Thread.sleep(1000);
        System.out.println("MAIN THREAD DONE");
    }
}
