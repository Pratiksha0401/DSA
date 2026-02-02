package org.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrates the difference between:
 * 1) Platform Threads (traditional OS threads)
 * 2) Virtual Threads (Java 21 - Project Loom)
 *
 * Scenario:
 * - Simulate 10,000 concurrent requests
 * - Each request performs a blocking operation (Thread.sleep)
 *
 * Purpose:
 * - Show how virtual threads handle massive concurrency efficiently
 * - Highlight scalability issues with platform threads
 */
public class VirtualThreadsVsPlatformThreads {

    /**
     * Total number of simulated requests.
     * Large number to demonstrate scalability difference.
     */
    private static final int REQUESTS = 10_000;

    public static void main(String[] args) throws Exception {

        System.out.println("=== PLATFORM THREADS ===");
        runWithPlatformThreads();

        System.out.println("\n=== VIRTUAL THREADS ===");
        runWithVirtualThreads();
    }

    /**
     * Executes requests using traditional platform threads.
     *
     * Key Characteristics:
     * - Uses OS-level threads
     * - Thread pool size is limited (200)
     * - Blocking operations consume OS threads
     *
     * Result:
     * - Requests are queued
     * - Higher memory usage
     * - Limited scalability
     */
    static void runWithPlatformThreads() throws Exception {
        long start = System.currentTimeMillis();

        // Fixed-size thread pool using platform (OS) threads
        ExecutorService executor = Executors.newFixedThreadPool(200);

        for (int i = 1; i <= REQUESTS; i++) {
            int id = i;

            // Each task represents a blocking request
            executor.submit(() -> handleRequest(id));
        }

        // Stop accepting new tasks
        executor.shutdown();

        // Wait until all tasks complete
        while (!executor.isTerminated()) {
            // busy wait for demo purposes
        }

        long end = System.currentTimeMillis();
        System.out.println("Platform Threads Time: " + (end - start) + " ms");
    }

    /**
     * Executes requests using virtual threads (Java 21).
     *
     * Key Characteristics:
     * - Lightweight JVM-managed threads
     * - One virtual thread per task
     * - Blocking does NOT block OS threads
     *
     * Result:
     * - Massive concurrency
     * - Minimal memory usage
     * - Simple synchronous code
     */
    static void runWithVirtualThreads() throws Exception {
        long start = System.currentTimeMillis();

        /*
         * newVirtualThreadPerTaskExecutor():
         * - Creates a new virtual thread for every submitted task
         * - Virtual threads are mounted/unmounted on carrier threads
         */
        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 1; i <= REQUESTS; i++) {
                int id = i;

                // Each request runs in its own virtual thread
                executor.submit(() -> handleRequest(id));
            }
        }
        // try-with-resources ensures executor shutdown

        long end = System.currentTimeMillis();
        System.out.println("Virtual Threads Time: " + (end - start) + " ms");
    }

    /**
     * Simulates a blocking I/O operation.
     *
     * Example real-world mappings:
     * - Database query (JDBC)
     * - REST API call
     * - File I/O
     *
     * In virtual threads:
     * - Blocking is cheap
     * - JVM unmounts the virtual thread
     * - Carrier thread executes other virtual threads
     */
    static void handleRequest(int id) {
        try {
            // Simulated blocking call
            Thread.sleep(1000);

            // Print thread type for verification
            if (id == 1) {
                System.out.println("Is Virtual Thread? → "
                        + Thread.currentThread().isVirtual());
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
