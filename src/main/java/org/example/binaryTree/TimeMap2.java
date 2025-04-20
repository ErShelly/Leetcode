package org.example.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap2 {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap2() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair<Integer, String>> values = map.get(key);

        String res = "";
        int left = 0, right = values.size()-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(values.get(mid).getKey()<=timestamp){
                res = values.get(mid).getValue();
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return res;
    }

    private class Pair<K,V>{
        private final K key;
        private final V value;
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}

