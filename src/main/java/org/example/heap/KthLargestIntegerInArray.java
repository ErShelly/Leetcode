package org.example.heap;

import java.util.PriorityQueue;

//1985
public class KthLargestIntegerInArray {
    public static void main(String[] args){
        System.out.println(kthLargestNumber(new String[]{"3","6","7","10"}, 2));

    }

    //Time : O(nlogk)
    //Space: O(k)
    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> {
           if(a.length() == b.length()){
               return a.compareTo(b);
           }
           return Integer.compare(a.length(), b.length());
        });

        for(String num : nums){
            queue.offer(num);

            if(queue.size() > k){
                queue.poll();
            }
        }

        return queue.peek();
    }
}
