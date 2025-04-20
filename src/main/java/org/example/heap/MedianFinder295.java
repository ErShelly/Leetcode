package org.example.heap;

import java.util.PriorityQueue;
import java.util.Queue;

// O(log n) for adding and removing from heap
//Time complexity: O(m∗logn) for addNum, O(m) for findMedian
//Space complexity: O(n)

//m is the number of function calls and
//n is the length of the array.
public class MedianFinder295 {
    private Queue<Integer> smallHeap; //max heap
    private Queue<Integer> largeHeap; //min Heap

    public MedianFinder295(){
        smallHeap = new PriorityQueue<>((a,b) -> b-a);
        largeHeap = new PriorityQueue<>((a,b) -> a-b);
    }

    public void addNum(int num){
        smallHeap.add(num);
        if(smallHeap.size() - largeHeap.size() > 1 || !largeHeap.isEmpty() && largeHeap.peek() < smallHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }

        if(largeHeap.size() - smallHeap.size() > 1){
            smallHeap.add(largeHeap.poll());
        }
    }

    public double findMedian(){
        if(smallHeap.size() == largeHeap.size()){
            return (double) (smallHeap.peek() + largeHeap.peek())/2;
        } else if(smallHeap.size() > largeHeap.size()){
            return smallHeap.peek();
        } else {
            return largeHeap.peek();
        }
    }
}
