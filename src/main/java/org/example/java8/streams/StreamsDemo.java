package org.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        //1. From collections
        int count = (int) nums.stream().filter(x -> x % 2 == 0).count();

        //2. From arrays
        String[] arrays = {"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arrays);

        //3. Using Stream.of
        Stream<String> stream2 = Stream.of("a", "b", "c");
        Stream<String> stream3 = Stream.of(arrays);

        //4. Infinite stream
        Stream<Integer> stream4 = Stream.generate(() -> 1);
        Stream.iterate(1, x-> x+1); //second argument is unary operator, input type and return type remains same

        //limit
        Stream<Integer> str = Stream.generate(()-> 1).limit(100);
    }
}
