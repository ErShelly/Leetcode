package org.example.queueCode;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CollectionsFrmwk {
    public static void main(String[] args){
        //Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        q.remove();
        System.out.println(q);

    }
}
