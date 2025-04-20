package org.example.linkedListCode;

public class LL {
    Node head;
    private int size;

    LL() {
        this.size = 0;
    }

    public static void main(String[] args) {
        LL ll = new LL();
        ll.addFirst("1");
        ll.addLast("2");
        ll.addLast("3");
        ll.addLast("4");
        ll.printList();
        ll.reverseIterate();
        //ll.head = ll.reverseRecursively(ll.head);
        ll.printList();
        System.out.println(ll.getSize());
    }

    public class Node {
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
            size++;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node currNode = head.next;
        Node prevNode = head;
        while (currNode.next != null) {
            prevNode = prevNode.next;
            currNode = currNode.next;
        }

        prevNode.next = null;
    }

    public Node reverseRecursively(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;

    }
    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    public int getSize() {
        return size;
    }
}
