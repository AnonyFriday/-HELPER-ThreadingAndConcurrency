/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.fileprocessing;

import thread.problems.fileprocessing.exceptions.GlobalUncaughtExceptionHandler;
import thread.problems.fileprocessing.exceptions.LineEmptyException;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duyvu
 */

/**
 * This class take responsibility for scanning periodically
 *
 * @author duyvu
 */
class Watcher implements Runnable {

    // ======================================
    // = Fields
    // ======================================
    final private String urlFolder;

    // ======================================
    // = Constructors
    // ======================================
    public Watcher(String urlFolder) {
        this.urlFolder = urlFolder;
    }

    // ======================================
    // = Methods
    // ======================================

    /**
     * Create a thread to scan a folder 'resources' for every 68s
     */
    @Override
    public void run() {
        File dir = new File(urlFolder);

        // Set the global exception in java
        Thread.currentThread().setUncaughtExceptionHandler(new GlobalUncaughtExceptionHandler());

        try {
            while (true) {
                if (Objects.requireNonNull(dir.listFiles()).length != 0) {
                    // Targeting only the files
                    // Applying the stream to hashing each file content
                    // Write a new file into the directory
                    Arrays
                            .stream(Objects.requireNonNull(dir.listFiles()))
                            .forEach(file -> {
                                Thread fileProcThread = new Thread(new FileProcessor(file));
                                fileProcThread.setUncaughtExceptionHandler(new LineEmptyException());
                                fileProcThread.start();
                            });
                }

                // Sleeping after scanning 1 file
                sleep(2000);
            }
        } catch (NullPointerException ex) {
            ex.getStackTrace();
        }
    }

    /**
     * Calling a thread to sleep after scanning the folder
     */
    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
