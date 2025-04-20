package org.example.linkedListCode;

import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n)
//Space Complexity: O(n)
public class ReorderListBruteForce {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void reorderLL(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null) {
            list.add(currNode);
            currNode = currNode.next;
        }

        int i=0;
        int j = list.size() - 1;
        while (i<j){
            list.get(i).next = list.get(j);
            i++;
            if(i>=j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;

        while(head!=null){
            System.out.print(head.val+"-->");
            head = head.next;
        }

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        reorderLL(listNode);
    }
}
