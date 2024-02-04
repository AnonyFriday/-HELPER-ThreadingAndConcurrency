/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories.volatilekeyword;

/**
 *
 * @author duyvu
 */
public class VolatileThread implements Runnable {

    private  boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Running in " + Thread.currentThread().getName());
        }
    }

    public void stopRunning() {
        stop = true;
    }

}
