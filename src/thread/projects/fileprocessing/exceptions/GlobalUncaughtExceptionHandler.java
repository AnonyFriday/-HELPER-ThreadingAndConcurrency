package thread.problems.fileprocessing.exceptions;

public class GlobalUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Thread: " + t.getName() + "\nProblem: " + e.getMessage());
    }
}
