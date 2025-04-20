package org.example.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //collect
        List<Integer> list2 = list.stream().skip(2).collect(Collectors.toList());

        //forEach
        list2.stream().forEach(System.out::println);

        //reduce : combines elements to produce a single result
        Optional<Integer> reduce = list.stream().reduce((x,y)->x+y); //sum
        Optional<Integer> sumUsingMethodReference = list.stream().reduce(Integer::sum); //Using method reference
        System.out.println(reduce.get());

        //count
        long count = list2.stream().count();

        //short circuit operations, when the condition is satisfied it returns the result
        //anyMatch
        boolean isAnyEven = list.stream().anyMatch(x->x%2==0);
        System.out.println(isAnyEven);

        //allMatch
        boolean isAllEven = list.stream().allMatch(x-> x%2==0);
        System.out.println(isAllEven);

        //noneMatch
        boolean noneGreaterThan5 = list.stream().noneMatch(x->x>5);
        System.out.println(noneGreaterThan5);
        boolean noneLessThan5 = list.stream().noneMatch(x->x<5);
        System.out.println(noneLessThan5);

        //findFirst
        System.out.println(list.stream().findFirst().get());

        //findAny
        System.out.println(list.stream().findAny().get());

        // toArray
        Object[] arr = Stream.of(1,2,3).toArray();

        //min and max
        System.out.println(Stream.of(1,22, 21).max(Comparator.naturalOrder()).get());
        System.out.println(Stream.of(1,22, 21).min(Comparator.naturalOrder()).get());

        // forEachOrdered
        //In Parallel stream, forEach will run in random order
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Using forEach with parallel stream");
        numbers.parallelStream().forEach(System.out::println);

        System.out.println("Using forEachOrdered with parallel stream");
        numbers.parallelStream().forEachOrdered(System.out::println);

        //Example count the occurrence
        String str = "Hellon World";
        System.out.println(str.chars().filter(x->x=='l').count());

        //Streams can be reused after a terminal operation has been called
    }
}
