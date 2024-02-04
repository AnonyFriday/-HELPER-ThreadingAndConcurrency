/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories.callable;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Callable just like Runnable, but
 *
 * - return a data
 *
 * - throw an exception
 *
 * @author duyvu
 */
public class CallableTask implements Callable<String> {
    
    @Override
    public String call() throws Exception {
        // API to indogo
        // processing
        // more intuitive than Runnable
        
        Thread.sleep(50);
        
        return "Return a data from Callable" + Thread.currentThread().getName();
    }
    
}
