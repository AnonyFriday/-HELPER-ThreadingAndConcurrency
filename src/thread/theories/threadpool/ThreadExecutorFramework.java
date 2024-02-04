/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author duyvu
 */
public class ThreadExecutorFramework {

    public static void main(String[] args) {

        
        // New Thread Pool
        ExecutorService executorServiceThreadPool = Executors.newFixedThreadPool(5);
        
        
        
        
        // New Single Thread Executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnableThread = new Runnable() {
            @Override
            public void run() {
                System.out.println("pool-1-thread-1");
            }
        };

        executorService.submit(runnableThread);
        executorService.submit(runnableThread);
        executorService.submit(runnableThread);

        executorService.shutdown();
        System.out.println("DONE");
    }
}
