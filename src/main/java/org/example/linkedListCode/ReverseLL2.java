package org.example.linkedListCode;

public class ReverseLL2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode reverseLL(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) prev = prev.next;

        ListNode curr = prev.next;
        ListNode nextNode;

        for (int i = 0; i < right - left; i++) {
             nextNode = curr.next;
             curr.next = nextNode.next;
             nextNode.next = prev.next;
             prev.next = nextNode;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode reversed = reverseLL(listNode, 2, 4);

        while (reversed != null){
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
}
