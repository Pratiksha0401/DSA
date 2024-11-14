package org.example.stack;


class Node{
    private int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public void  printLinkedList(Node head){
        Node tmp = head;
        while (tmp!=null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public Node push(Node node, int n) {
        Node head = new Node(n);
        head.next=node;
        return head;
    }
    public Node insertAtLast(Node node, int n) {
        Node newNode = new Node(n);
        if(node==null){
            return newNode;
        }
        Node tmp =node;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
        return node;
    }

    public Node insertAtIndex(Node node, int n, int index) {
        Node newNode = new Node(n);
        if(node==null){

            return newNode;
        }
        Node tmp =node;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
        return node;
    }


}


public class LinkedListAsStack {

        public static void main(String[] args) {
            Node node = new Node(2);
            node.next = new Node(3);
            node.next.next = new Node(4);
            node = node.push(node, 1);
            node =node.insertAtLast(node,5);
            node = node.insertAtIndex(node, 11, 3);
            node.printLinkedList(node);
        }

    }


