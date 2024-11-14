package org.example.DSA.LinkedList;

public class Runner {
    public static void main(String[] args) {

        LinkedList linkedList =new LinkedList();
        linkedList.insert(5);
        linkedList.insert(12);
        linkedList.insert(3);
        linkedList.insertAtStart(9);
        linkedList.insertAtIndex(0,6);

        linkedList.display();
        System.out.println("after delete at first");
        linkedList.deleteAtFirst();
        linkedList.display();
        System.out.println("after delete at index 2");
        linkedList.deleteAt(2);
        linkedList.display();
        linkedList.deleteAtLast();
        System.out.println("after delete at last");
        linkedList.display();


    }
}
