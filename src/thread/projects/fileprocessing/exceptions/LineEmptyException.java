/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.fileprocessing.exceptions;

import java.util.logging.Logger;

/**
 * JVM will query the thread for its UncaughExceptionHandler
 * before terminating due to an uncaught exception
 *
 * @author duyvu
 */
public class LineEmptyException implements Thread.UncaughtExceptionHandler {

    private static Logger LOGGER = Logger.getLogger(String.valueOf(LineEmptyException.class));

    @Override
    public void uncaughtException(Thread t,
                                  Throwable e) {
        LOGGER.info(e.getMessage());
    }
}
