package org.example.linkedListCode;

class ListNode {
    int data;
    ListNode2 next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IntersectLL {
    public ListNode2 getIntersectionNode(ListNode2 headA, ListNode2 headB) {
        ListNode2 a = headA;
        ListNode2 b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return b;
    }
}
