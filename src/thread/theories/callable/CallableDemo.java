/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
public class CallableDemo {

    public static void main(String[] args) throws TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CallableTask callableTask = new CallableTask();
        Future<String> future = executorService.submit(callableTask);

//        try {
//            if (future.isDone()) {
//                System.out.println(future.get(100, TimeUnit.MILLISECONDS)); // provide the time limit to finish the task 
//            }
//
//            System.out.println(future.get(100, TimeUnit.MILLISECONDS)); // provide the time limit to finish the task 
//        } catch (InterruptedException ex) {
//            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ExecutionException ex) {
//            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // A list of Callable Task
        List<CallableTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(callableTask);
        }

        try {

            // Wait all tasks to complete and return the list of futures
            List<Future<String>> futureList = executorService.invokeAll(tasks);

            for (Future<String> future1 : futureList) {
                System.out.println(future1.get());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Executoire Service takes no more incoming tasks
        executorService.shutdown();

        try {

            // Wait for all the tasks submitted to the service to complete execution
            // The maximum time to wait for all the tasks submitted to finish.
            executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
