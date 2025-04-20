package org.example.linkedListCode;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left; //Least recently used
    private Node right; //Most recently used

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left =  new Node(0, 0);
        this.right  = new Node(0, 0);
        this.right.prev = this.left;
        this.left.next = this.right;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        next.prev = prev;
        prev.next = next;
    }

    private void insert(Node node){
        //insert at end as most recently used
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key){
        if(!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int val){
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node newNode = new Node(key, val);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > this.capacity){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }

    }
}
