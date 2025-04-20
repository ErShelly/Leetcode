package org.example.linkedListCode;

class ListNode2 {
    int data;
    ListNode2 next;
    ListNode2(int data){
        this.data = data;
        this.next = null;
    }
}
public class LLRandom {
    private static ListNode2 reverseLL(ListNode2 listNode2){
        ListNode2 head = listNode2;

        ListNode2 curr = head;
        ListNode2 prev = null;
        ListNode2 next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode2 middleOfLL(ListNode2 listNode2){
        if(listNode2.next == null) return listNode2;

        ListNode2 slow = listNode2;
        ListNode2 fast = listNode2;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Floyd’s Cycle Detection Algorithm
    private static boolean hasCycleLL(ListNode2 listNode2){
        ListNode2 slow = listNode2;
        ListNode2 fast = listNode2;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }

    private static void printNodes(ListNode2 listNode2){
        while(listNode2 != null){
            System.out.print(listNode2.data+ " ");
            listNode2 = listNode2.next;
        }
        System.out.println();
    }

    private static boolean isPalindrome(ListNode2 listNode2){
        ListNode2 node = middleOfLL(listNode2);

        ListNode2 head = listNode2;
        ListNode2 slow = reverseLL(node);

        while (slow != null && head.data == slow.data){
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }

    public static void main(String[] args){
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);

        printNodes(head);
        ListNode2 mid = middleOfLL(head);
        System.out.println("Mid: " + mid.data);
        System.out.println("Cycle: " + hasCycleLL(head));
        ListNode2 reversedNode = reverseLL(head);
        printNodes(reversedNode);

        ListNode2 head2 = new ListNode2(1);
        head2.next = new ListNode2(2);
        head2.next.next = new ListNode2(2);
        head2.next.next.next = new ListNode2(1);

        System.out.println("IsPalindrome: " + isPalindrome(head2));
    }
}
