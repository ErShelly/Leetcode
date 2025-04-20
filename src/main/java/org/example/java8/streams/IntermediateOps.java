package org.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        //1. filter
        List<String> list = Arrays.asList("Aname", "Bname", "Cname", "Aname");
        Stream<String> stream = list.stream().filter(x -> x.startsWith("A"));
        //no filtering until terminal operation invoked.
        long count = list.stream().filter(x -> x.startsWith("A")).count();

        //2. map
        Stream<String> stream2 = list.stream().map(x -> x.toUpperCase());
        Stream<String> stream3 = list.stream().map(String::toUpperCase);

        //3. Sorted
        List<Integer> numbers = Arrays.asList(5, 1, 3, 2, 4);

        // Sort in natural order
        List<String> sortedStream = list.stream().sorted().collect(Collectors.toList());
        //Natural Order: a.compareTo(b) compares a to b.
        //Returns:
        //Negative: if a is less than b
        //Zero: if a equals b
        //Positive: if a is greater than b
        List<String> reverseOrder = list.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        List<String> sortedStreamUsingComparator = list.stream().sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());

        //distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        //limit
        Stream.iterate(1, x -> x + 1).limit(100).forEach(System.out::println);

        //skip
        Stream.iterate(1, x -> x + 1).skip(30).limit(100).forEach(System.out::println);

        //peek
        //Performs an action on each element as it is consumed
        Stream.iterate(1, x -> x + 1).skip(30).limit(100).peek(System.out::println).count();

        //flatMap
        //Handle streams of collections, lists or arrays where each element is itself a collection
        //Flattened nested structures(e.g. lists within lists) so that they can be processed as single sequence of
        //elements
        //Transform and flatten elements at the same time.
        List<List<String>> listsOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("grape", "pear"),
                Arrays.asList("orange", "kiwi")
        );

        System.out.println(listsOfLists.stream()
                .flatMap(x -> x.stream())
                .map(String::toUpperCase)
                .collect(Collectors.toList()));

        //Example
        List<String> sentences = Arrays.asList(
                "Hello World",
                "This is stream",
                "demo"
        );

        System.out.println(sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .collect(Collectors.toList()));
    }
}
