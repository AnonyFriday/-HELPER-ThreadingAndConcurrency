/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.fileprocessing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duyvu
 */
public class FileProcessor implements Runnable {

    // ======================================
    // = Fields
    // ======================================
    private final File file;
    private final String OUTPUT_PATH = "./src/thread/problems/fileprocessing/output/";

    // ======================================
    // = Constructor
    // ======================================
    public FileProcessor(File file) {
        this.file = file;
    }

    // ======================================
    // = Methods
    // ======================================

    /**
     * A thread handling hashing each line of the file and write to the output file
     */
    @Override
    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_PATH + file.getName()));

            // Hashing each line of the file 
            // For each line, write to the output file and append the \n at each line
            Files.lines(Path.of(file.getCanonicalPath()), StandardCharsets.UTF_8)
                    .map(line -> HashingEncrypter.getHexaDigest(HashingEncrypter.SHA_256, line))
                    .forEach(line -> {
                        try {
                            writer.write(line + '\n');
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

            // Closing the writer
            writer.close();
        } catch (
                IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(Thread
                .currentThread()
                .getName() + " -> processed file: " + file.getName());
    }
}
