/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configure the Thread Pool without using the Executor FrameworkF
 *
 * @author duyvu
 */
public class ThreadPoolExecutorDemo {

    static int corePoolSize = 5;         // create 5 threads
    static int maxPoolSize = 10;         // my max threads can go up to 10
    // after a thread finishes its task, it will wait upto 5s to see 
    // if more task coming or not
    // if having more task, a task will be assigned to that thread
    // if no more task, it will wait 5s, then die, 
    // until there were only 5 threads in the pool (the core threads)
    static int keepAliveTime = 5000;

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(200));

        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            executorService.submit(() -> {
                try {
                    System.out.println("Executing in " + Thread.currentThread().getName());
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadPoolExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadPoolExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    System.out.println("Executing another task in " + Thread.currentThread().getName());
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadPoolExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

        // Do not accept any new task, wait for previously sunmmitted tasks to execute and then terminates the executor
        executorService.shutdown();

        //
    }
}
