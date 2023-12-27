package synchronization.projects.readwrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Main {


    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        // Provide only 2 methods
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();


        // If other thread is writing then stop here until no othre thread is writing
        readLock.lock();


        readLock.unlock();

    }
}
