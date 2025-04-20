package org.example.linkedListCode;


import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyLLWithRandomPointer {

    // Two pass
    //Time complexity: O(n)
    //space complexity: O(n)

    public Node copyRandomListWithTwoPass(Node head) {
        HashMap<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            oldToCopy.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = oldToCopy.get(curr);
            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);
            curr = curr.next;
        }

        return oldToCopy.get(head);
    }

    //Time complexity: O(n) + O(n) + O(n) = O(n)
    //space complexity: O(1)
    private static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node l1 = head;
        while (l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }

        Node newHead = head.next;

        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random.next;
            }
            l1 = l1.next.next;
        }

        l1 = head;
        while (l1 != null) {
            Node l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }

        return newHead;
    }
}
