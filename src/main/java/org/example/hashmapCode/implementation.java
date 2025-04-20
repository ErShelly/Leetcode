package org.example.hashmapCode;

import java.security.Key;
import java.util.*;

public class implementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // no. of total nodes
        private int N; // no. of buckets(size of an array)
        private LinkedList<Node> buckets[];

        public HashMap() {
            this.N = 4; //suppose size is 4 of an array
            // Initializing the size of buckets
            this.buckets = new LinkedList[4];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            //bi is bucket index
            int bi = key.hashCode();

            //bucket index should always be between 0 to N-1
            return Math.abs(bi) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i; //di
                }
            }
            return -1;
        }

        //yh rehash baad mein puchlena likhna h ya ni
        // Rehash jb loadfactor reach kr jae
        private void rehash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N * 2];

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        //

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                this.buckets[bi].add(new Node(key, value));
                n++;
            } else {
                Node node = this.buckets[bi].get(di);
                node.value = value;
            }

            // yh part load factor k liye hai..
            // yha 2 assume kiya hai..
            double lambda = (double) n / N;
            if (lambda > 2.0) { //some K constant
                rehash();
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) return null;

            Node node = buckets[bi].get(di);
            return node.value;
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            return di != -1;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null;
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    keys.add(ll.get(j).key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
        map.put("Bangladesh", 5);
        map.put("UK", 150);

        System.out.println(map.containsKey("CA"));
        map.remove("UK");

        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++){
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }
    }
}
