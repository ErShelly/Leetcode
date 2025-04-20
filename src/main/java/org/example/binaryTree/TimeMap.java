package org.example.binaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Time based key value store
public class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, Integer timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);

//        if (!map.containsKey(key)) {
//            map.put(key, new TreeMap<>());
//        }
//        map.get(key).put(timestamp, value);
    }

    public String get(String key, Integer timestamp) {
        if(!map.containsKey(key)) return "";

        Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }

    public static void main(String[] args){
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 2));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
        System.out.println(timeMap.get("foo", 0));
    }
}
