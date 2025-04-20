package org.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args){
        List<String> arrayList = Arrays.asList("A", "B", "C");
        //constructor reference
        List<MobilePhone> mobilePhones = arrayList.stream().map(x-> new MobilePhone(x)).collect(Collectors.toList());
        // replace lambda with method reference
        List<MobilePhone> mobilePhones1 = arrayList.stream().map(MobilePhone::new).collect(Collectors.toList());

    }
}

class MobilePhone{
    public String name;
    public MobilePhone(String name){
        this.name = name;
    }
}
