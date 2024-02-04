/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author duyvu
 */
public class VisitorDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        VisitorCounterTask task = new VisitorCounterTask();

        for (int i = 0; i < 1000000; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Total Visitors: " + VisitorCounterTask.totalCount);
        System.out.println("Total Atotic Visitors: " + VisitorCounterTask.atomicTotalCount.get());
    }
}
