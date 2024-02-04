/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.theories.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author duyvu
 */
public class VisitorCounterTask implements Runnable {

    // If do not apply the synchronization, race condition will happen
    static int totalCount = 0;

    // Total count with atomic value
    static AtomicInteger atomicTotalCount = new AtomicInteger(0);

    @Override
    public void run() {
        increment();
        atomicTotalCount.incrementAndGet();
    }

    private synchronized void increment() {
        totalCount++;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public static AtomicInteger getAtomicTotalCount() {
        return atomicTotalCount;
    }
}
