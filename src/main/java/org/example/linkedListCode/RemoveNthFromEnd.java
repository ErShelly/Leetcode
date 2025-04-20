package org.example.linkedListCode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6, null))))));
        //ListNode head = removeNthNodeFromEnd(listNode, 2);

        ListNode head = removeNthNodeFromEndOptimal(listNode, 2);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    //Time & Space Complexity : O(n)
    public static ListNode removeNthNodeFromEnd(ListNode head, int n){
        List<ListNode> nodes = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null){
            nodes.add(currNode);
            currNode = currNode.next;
        }

        int removeIdx = nodes.size() - n;
        if(removeIdx == 0){
            return head.next;
        }
        nodes.get(removeIdx-1).next = nodes.get(removeIdx).next;
        return head;
    }

    //Time O(n)
    //Space O(1)
    public static ListNode removeNthNodeFromEndOptimal(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while(n>0){
            right = right.next;
            n--;
        }

        while (right!=null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
