/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.fileprocessing;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
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
    private String urlFolder;

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

        while (true) {
            if (dir.listFiles().length != 0) {
                // Targeting only the files
                // Applying the stream to hashing each file content
                // Write a new file into the directory
                Arrays
                        .stream(dir.listFiles())
                        .forEach(file -> new Thread(new FileProcessor(file)).start());
            }

            // Sleeping after scanning
             sleep();
        }
    }

    /**
     * Calling a thread to sleep after scanning the folder
     */
    public void sleep() {
        try {
            Thread.sleep(68000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
