package org.example.java8;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        IntStream stream = Arrays.stream(nums);
        System.out.println(IntStream.range(1,5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));

        IntStream.of(1,2,3);

        IntStream intStream = new Random().ints(5);
        System.out.println(intStream.boxed().collect(Collectors.toList()));

        DoubleStream doubleStream = new Random().doubles(5);
        System.out.println(doubleStream.boxed().collect(Collectors.toList()));
    }
}
