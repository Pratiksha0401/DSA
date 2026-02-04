package org.example.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

    public static void main(String[] args) {

        ForkJoinPool pool = ForkJoinPool.commonPool();

        SumTask task = new SumTask(1, 100);

        long result = pool.invoke(task);

        System.out.println("Final Result = " + result);
    }
}

// RecursiveTask because it RETURNS a value
class SumTask extends RecursiveTask<Long> {

    private final int start;
    private final int end;
    private static final int THRESHOLD = 10;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        // Base condition
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            System.out.println("Computed directly: " + start + " to " + end +
                    " by " + Thread.currentThread());
            return sum;
        }

        // Split task (FORK)
        int mid = (start + end) / 2;

        SumTask leftTask = new SumTask(start, mid);
        SumTask rightTask = new SumTask(mid + 1, end);

        leftTask.fork();              // execute asynchronously
        Long rightResult = rightTask.compute(); // compute directly
        Long leftResult = leftTask.join();      // wait & get result

        return leftResult + rightResult;
    }
}

