/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.fileprocessing.exceptions;

/**
 *
 * @author duyvu
 */
public class LineEmptyException implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t,
                                  Throwable e) {
        System.out.println("Exception handled: " + e.getMessage() + "at thread: " + t.getName());
    }
}
