package org.example.linkedList;

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

    public Node insertAtFirst(Node node, int n) {
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
        Node tmp = node;
        for(int i=1;i<index;i++) {
            tmp = tmp.next;
        }
        Node tmp1 = tmp.next;
        newNode.next = tmp1;
        tmp.next=newNode;
        return node;
    }

    public Node deletAtFirst(Node head){
        head=head.next;
        return head;
    }

     public Node deletAtLast(Node head){
        Node tmp = head;
         while(tmp.next.next!=null){
             tmp= tmp.next;
         }
         tmp.next=null;
         return head;
     }

     public Node deletAtIndex(Node head, int n){
        Node tmp = head;
         for (int i=1;i<n;i++){
             tmp= tmp.next;
         }

         tmp.next=tmp.next.next;
         return head;
     }

     public Node reverseLinkedList(Node head){

        return head;
     }
 }
public class Linked {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        node = node.insertAtFirst(node, 1);
        node = node.insertAtLast(node,6);
        node = node.insertAtIndex(node, 11, 3);
        node = node.deletAtFirst(node);
        node = node.deletAtLast(node);
        node = node.deletAtIndex(node,2);
        node.printLinkedList(node);
    }

}
