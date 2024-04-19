package main.java.sgu.ru;

import java.util.concurrent.RecursiveTask;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class FibonacciCalculator extends RecursiveTask<Integer> {
    private int n;

    public FibonacciCalculator(int n) {
        this.n = n;
    }

    protected Integer compute() {
        if (n <= 1) {
            return n;
        } else {
            FibonacciCalculator f1 = new FibonacciCalculator(n - 1);
            f1.fork();
            FibonacciCalculator f2 = new FibonacciCalculator(n - 2);
            return f2.compute() + f1.join();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите N:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        int n = Integer.parseInt(input);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator(n);
        int result = forkJoinPool.invoke(fibonacciCalculator);
        System.out.println("N-ное число Фибоначчи: " + result);
    }
}

