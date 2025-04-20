package org.example.java8.collectorsDemo;

import java.sql.Struct;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args){
        //Collectors is a utility class
        //Provides a set of methods to create common collectors

        //Collecting to a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> list = names.stream().filter(x-> x.startsWith("A")).collect(Collectors.toList());

        //Collecting to a Set
        List<Integer> nums = Arrays.asList(1,2,2,3,3,3,4,4,5,5);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());

        System.out.println(set);

        //Collecting to specific collection
        ArrayDeque<String> arr = names.stream().collect(Collectors.toCollection(()->new ArrayDeque<>()));

        //Joining strings
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatenatedNames);

        //Summarizing Data
        //Generates statistical summary (count, sum, min, average, max)
        List<Integer> numsList = Arrays.asList(2,5,6,7,10);
        IntSummaryStatistics stats = numsList.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println(stats);

        //Calculating Averages
        System.out.println(numsList.stream().collect(Collectors.averagingInt(x->x)));

        //Counting elements
        System.out.println(numsList.stream().collect(Collectors.counting()));

        //Grouping
        List<String> words = Arrays.asList("Hello", "World", "Java", "Streams", "Collectors");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(","))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));

        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

        System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length()>5)));
        System.out.println(words.stream().map(String::toUpperCase).collect(Collectors.toList()));

        String sentence = "Hello world Hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x, Collectors.counting())));

        //partitioning even and odd numbers
        List<Integer> l2 = Arrays.asList(1,2,3,4,5);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x->x%2==0)));

        //Summing values in a map
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 15);
        map.put("Orange", 20);
        System.out.println(map.values().stream().reduce(Integer::sum).get());
        System.out.println((Integer) map.values().stream().mapToInt(x -> x).sum());
        System.out.println(map.values().stream().collect(Collectors.summingInt(x->x)));

        //Creating a map from stream elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));

        List<String> words2 = Arrays.asList("apple", "banana", "apple", "banana", "orange");
        System.out.println(words2.stream().collect(Collectors.toMap(k->k, v->1, (x,y)->x+y))); //merge function


    }
}
