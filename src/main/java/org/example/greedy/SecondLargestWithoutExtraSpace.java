package org.example.greedy;

public class SecondLargestWithoutExtraSpace {
    public static void main(String[] args){
        System.out.println(findSecondLargest(new int[] {12, 35, 1, 10, 34, 1}));
        System.out.println(findSecondLargest(new int[] {1, 1, 1, 1, 1}));
        System.out.println(findSecondLargest(new int[] {2}));

    }

    //Time: O(n)
    //Space: O(1)
    public static int findSecondLargest(int[] arr){
        if(arr == null || arr.length < 2) return -1;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int num: arr){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            } else if(num > secondLargest && num != largest){
                secondLargest = num;
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
