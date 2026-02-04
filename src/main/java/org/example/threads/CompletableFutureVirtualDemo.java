package org.example.threads;

import java.util.*;
import java.util.concurrent.*;

public class CompletableFutureVirtualDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("Main started on thread: " + Thread.currentThread());

        // ==========================================================
        // 1️⃣ Blocking way (get) — BLOCKS main thread
        // ==========================================================
        CompletableFuture<Integer> blockingFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    System.out.println("Blocking task thread: " + Thread.currentThread());
                    return 10;
                });

        Integer blockingResult = blockingFuture.get(); // ❌ blocking
        System.out.println("Blocking result: " + blockingResult);

        // ==========================================================
        // 2️⃣ Non-blocking way (thenAccept)
        // ==========================================================
        CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            System.out.println("Non-blocking task thread: " + Thread.currentThread());
            return 20;
        }).thenAccept(result ->
                System.out.println("Non-blocking result: " + result)
        );

        System.out.println("Main continues immediately (non-blocking)");

        // ==========================================================
        // 3️⃣ Chaining (thenApply → thenCompose)
        // ==========================================================
        CompletableFuture<Integer> chained =
                CompletableFuture.supplyAsync(() -> 5)
                        .thenApply(x -> x * 2)
                        .thenCompose(x ->
                                CompletableFuture.supplyAsync(() -> x * 3)
                        );

        chained.thenAccept(result ->
                System.out.println("Chained result: " + result)
        );

        // ==========================================================
        // 4️⃣ Combine two futures
        // ==========================================================
        CompletableFuture<Integer> f1 =
                CompletableFuture.supplyAsync(() -> 100);

        CompletableFuture<Integer> f2 =
                CompletableFuture.supplyAsync(() -> 200);

        f1.thenCombine(f2, Integer::sum)
                .thenAccept(result ->
                        System.out.println("Combined result: " + result)
                );

        // ==========================================================
        // 5️⃣ Exception handling
        // ==========================================================
        CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Boom!");
        }).exceptionally(ex -> {
            System.out.println("Exception handled: " + ex.getMessage());
            return -1;
        }).thenAccept(result ->
                System.out.println("Recovered value: " + result)
        );

        // ==========================================================
        // 6️⃣ MULTIPLE TASKS IN PARALLEL (Platform Threads)
        // ==========================================================
        System.out.println("\n--- Multiple async tasks (Platform Threads) ---");

        List<CompletableFuture<Integer>> tasks = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            CompletableFuture<Integer> task =
                    CompletableFuture.supplyAsync(() -> {
                        System.out.println("Task " + taskId +
                                " running on " + Thread.currentThread());
                        sleep(1000);
                        return taskId * 10;
                    });

            tasks.add(task);
        }

        // Wait for ALL tasks (non-blocking internally)
        CompletableFuture.allOf(
                tasks.toArray(new CompletableFuture[0])
        ).join();

        tasks.forEach(t ->
                System.out.println("Task result: " + t.join())
        );

        // ==========================================================
        // 7️⃣ MULTIPLE TASKS WITH VIRTUAL THREADS (Java 21)
        // ==========================================================
        System.out.println("\n--- Multiple async tasks (Virtual Threads) ---");

        try (ExecutorService virtualExecutor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            List<CompletableFuture<Integer>> virtualTasks = new ArrayList<>();

            for (int i = 1; i <= 5; i++) {
                int taskId = i;
                CompletableFuture<Integer> vt =
                        CompletableFuture.supplyAsync(() -> {
                            System.out.println("Virtual Task " + taskId +
                                    " running on " + Thread.currentThread());
                            sleep(1000);
                            return taskId * 100;
                        }, virtualExecutor);

                virtualTasks.add(vt);
            }

            CompletableFuture.allOf(
                    virtualTasks.toArray(new CompletableFuture[0])
            ).join();

            virtualTasks.forEach(v ->
                    System.out.println("Virtual task result: " + v.join())
            );
        }

        // ==========================================================
        // Keep JVM alive so async tasks finish
        // ==========================================================
        sleep(3000);
        System.out.println("Main finished");
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
