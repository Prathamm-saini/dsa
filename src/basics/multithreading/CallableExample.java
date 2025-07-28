package basics.multithreading;

import java.util.concurrent.*;

class MyCallable implements Callable<String> {

    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    // Implement the call method from Callable interface
    @Override
    public String call() throws Exception {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append("Callable ").append(name).append(" is running: ").append(i).append("n");
            Thread.sleep(500); // Pause execution for 500 milliseconds
        }
        return result.toString(); // Return the result as a String
    }
}


public class CallableExample {
    public static void main(String[] args) {
        // Create ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create Callable instances
        Callable<String> callable1 = new MyCallable("Task 1");
        Callable<String> callable2 = new MyCallable("Task 2");

        try {
            // Submit Callable tasks to the executor and get Future objects
            Future<String> future1 = executor.submit(callable1);
            Future<String> future2 = executor.submit(callable2);

            // Get results from Future objects
            System.out.println("Result from first task:");
            System.out.println(future1.get()); // Blocks until the task completes

            System.out.println("Result from second task:");
            System.out.println(future2.get()); // Blocks until the task completes

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task execution interrupted: " + e.getMessage());
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
    }
}