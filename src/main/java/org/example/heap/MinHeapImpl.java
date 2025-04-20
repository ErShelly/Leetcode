package org.example.heap;

import java.util.ArrayList;

public class MinHeapImpl {
    private ArrayList<Integer> minHeap;

    public MinHeapImpl(){
        this.minHeap = new ArrayList<>();
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int leftChild(int i){
        return 2*i + 1;
    }

    private int rightChild(int i){
        return 2*1 + 2;
    }

    private void swap(int i, int j){
        int temp = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, temp);
    }

    public void insert(int value){
        minHeap.add(value);
        int currIdx = minHeap.size() - 1;

        while (currIdx>0 && minHeap.get(currIdx) < minHeap.get(parent(currIdx))){
            swap(currIdx, parent(currIdx));
            currIdx = parent(currIdx);
        }
    }

    public int extract(){
        if(minHeap.isEmpty()){
            throw new RuntimeException("Heap is empty.");
        }

        int min = minHeap.get(0); //root
        int lastElement = minHeap.remove(minHeap.size() - 1);

        if(!minHeap.isEmpty()) {
            minHeap.set(0, lastElement);

            int currIdx = 0;
            while (true) {
                int left = leftChild(currIdx);
                int right = rightChild(currIdx);

                int smallest = currIdx;

                if (left > 0 && minHeap.get(left) < minHeap.get(smallest)) {
                    smallest = left;
                }

                if (right > 0 && minHeap.get(right) < minHeap.get(smallest)) {
                    smallest = right;
                }

                if (smallest == currIdx) break;

                swap(smallest, currIdx);
                currIdx = smallest;
            }
        }

        return min;
    }

    public void printHeap() {
        System.out.println(minHeap);
    }
}

class MinHeapExample{
    public static void main(String[] args){
        MinHeapImpl minHeap = new MinHeapImpl();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(9);

        minHeap.printHeap();

        System.out.println("Extracted Min "+ minHeap.extract());
        System.out.println("Extracted Min "+ minHeap.extract());
    }
}

