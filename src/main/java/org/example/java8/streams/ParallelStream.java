package org.example.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream {
    //Parallel streams enable us to execute code in parallel on separate cores.
    // The final result is the combination of each individual outcome.
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        List<Long> factorialList = list.stream().map(ParallelStream::factorial).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken with sequential stream in ms: " + timeTaken);

        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream().map(ParallelStream::factorial).collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream in ms: " + (endTime - startTime));
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
