package com.elysian.java.training.d02.s3;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ParallelProcessingExample {

    private static final int CORES_NUMBER = Runtime.getRuntime().availableProcessors();

    private static final Random RANDOM = new Random(200);

    public static void main(String[] args) {
        int threadsCount = CORES_NUMBER;
        System.out.println("Running with " + threadsCount + " threads");

        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);
        ExecutorCompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(executorService);

        long now = System.currentTimeMillis();

        int numberOfTasks = 0;
        // 1 - forking
        for (int i = 0; i < 20; i++) {
            // submitting new tasks to the completion service
            executorCompletionService.submit(new DepositStockProcessor());
            numberOfTasks++;
        }

        // 3 - joining
        int totalStock = 0;
        for (int i = 0; i <= numberOfTasks; i++) {
            try {
                final Future<Integer> poll = executorCompletionService.poll(200, TimeUnit.MILLISECONDS);
                if (poll != null && poll.isDone()) {
                    int stock = poll.get();
                    totalStock += stock;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("There are " + totalStock + " products");
        System.out.println("The processing took " + (System.currentTimeMillis() - now) + " ms");

        // shutting down the thread pool
        final List<Runnable> runnables = executorService.shutdownNow();
        System.out.println("There are " + runnables.size() + " unfinished tasks");
    }

    private static class DepositStockProcessor implements Callable<Integer> {

        // 2 - processing
        @Override
        public Integer call() throws InterruptedException {
            String threadName = Thread.currentThread().getName();
            int stock = RANDOM.nextInt(200);
            System.out.println(threadName + " - " + stock);

            Thread.sleep(stock * 20);

            return stock;
        }
    }
}
