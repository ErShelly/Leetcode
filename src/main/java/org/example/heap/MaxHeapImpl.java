package org.example.heap;

import java.util.ArrayList;

public class MaxHeapImpl {
    private ArrayList<Integer> maxHeap;

    public MaxHeapImpl() {
        this.maxHeap = new ArrayList<>();
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private int leftChild(int idx) {
        return idx * 2 + 1;
    }

    private int rightChild(int idx) {
        return idx * 2 + 2;
    }

    private void swap(int i, int j) {
        int temp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, temp);
    }

    public void insert(int value) {
        maxHeap.add(value);

        int currIdx = maxHeap.size() - 1;
        while (currIdx > 0 && maxHeap.get(currIdx) > maxHeap.get(parent(currIdx))) {
            swap(currIdx, parent(currIdx));
            currIdx = parent(currIdx);
        }
    }

    public int extractMax() {
        if (maxHeap.isEmpty()) throw new RuntimeException("Heap is empty");

        int max = maxHeap.get(0); //root

        int lastElement = maxHeap.remove(maxHeap.size() - 1);
        if (!maxHeap.isEmpty()) {
            maxHeap.set(0, lastElement);

            int currIdx = 0;
            while (true) {
                int left = leftChild(currIdx);
                int right = rightChild(currIdx);

                int largest = currIdx;
                if (left > 0 && maxHeap.get(left) > maxHeap.get(currIdx)) {
                    largest = left;
                }

                if (right > 0 && maxHeap.get(right) > maxHeap.get(currIdx)) {
                    largest = right;
                }

                if (currIdx == largest) break;

                swap(currIdx, largest);
                currIdx = largest;
            }
        }

        return max;
    }

    public void printMaxHeap() {
        System.out.println(maxHeap);
    }
}

class MaxHeapImp {
    public static void main(String[] args) {
        MaxHeapImpl maxHeap = new MaxHeapImpl();
        maxHeap.insert(9);
        maxHeap.insert(10);
        maxHeap.insert(15);
        maxHeap.insert(19);
        maxHeap.insert(12);

        maxHeap.printMaxHeap();
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
    }
}
