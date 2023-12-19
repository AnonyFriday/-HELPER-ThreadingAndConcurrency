/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.fileprocessing;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * === REQUIREMENTS ===
 * 1. Periodically scans the .src/thread/problems/fileprocessing/resources directory and matches for new files
 * 2. For each file found into this directory, a new thread should take care of its processing
 * 3. Processing = each line of the file will be hashed using a hashing algorithm (SHA256, etc.)
 * 4. The program will create new files, marked _output suffix, and they will placed into ./src/main/resources/output
 * 5. Throw an exception if a line is empty
 *
 * @author duyvu
 */
public class Main {

    /**
     * Main function to execute the thread Watcher on resoureces folder
     *
     * @param args
     */
    public static void main(String[] args) {
        final String urlFolder = "./src/thread/problems/fileprocessing/resources";
        new Thread(new Watcher(urlFolder)).start();
    }
}
