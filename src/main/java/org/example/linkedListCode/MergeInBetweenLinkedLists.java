package org.example.linkedListCode;
class ListNode3{
    int val;
    ListNode3 next;
    ListNode3(){}

    ListNode3(int val){
        this.val = val;
        this.next = null;
    }
}
public class MergeInBetweenLinkedLists {
    public static void main(String[] args){
        ListNode3 list1 = new ListNode3(0);
        list1.next = new ListNode3(1);
        list1.next.next = new ListNode3(2);
        list1.next.next.next = new ListNode3(3);
        list1.next.next.next.next = new ListNode3(4);
        list1.next.next.next.next.next = new ListNode3(5);

        ListNode3 list2 = new ListNode3(100);
        list2.next = new ListNode3(101);
        list2.next.next = new ListNode3(102);

        int a = 2, b = 4; // Replace nodes from 2 to 4 with list2

        ListNode3 result = mergeInBetween(list1, a, b, list2);
        printList(result);
    }

    public static void printList(ListNode3 head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    //Time: O(n+m)
    //Space: O(1)
    public static ListNode3 mergeInBetween(ListNode3 list1, int a, int b, ListNode3 list2){
        ListNode3 prev = list1;
        ListNode3 next = list1;

        for(int i=0; i<a-1;i++){
            prev = prev.next;
        }

        next = prev.next;
        for(int i=a; i<=b; i++){
            next = next.next;
        }

        prev.next = list2;

        ListNode3 temp= list2;
        while (temp.next!=null){
            temp = temp.next;
        }

        temp.next = next;
        return list1;

    }
}
