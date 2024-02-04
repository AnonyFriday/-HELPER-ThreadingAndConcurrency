/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories.volatilekeyword;

/**
 *
 * @author duyvu
 */
public class VolatileDemo {

    public static void main(String[] args) {

        VolatileThread aRunnale = new VolatileThread();

        new Thread(aRunnale).start();

        aRunnale.stopRunning();
    }
}
