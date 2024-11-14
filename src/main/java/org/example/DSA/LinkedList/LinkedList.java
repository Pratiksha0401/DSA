package org.example.DSA.LinkedList;

public class LinkedList {
    Node head;
    public void insert(int data){
        Node node = new Node();
        node.data=data;
        node.next=null;
        if(head==null){
            head=node;
        }else {
            Node n = head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
        }
    }

    public void insertAtStart(int data){
        Node node = new Node();
        node.data=data;
        node.next=null;
        node.next= head;
        head=node;



    }

    public void insertAtIndex(int index,int data){
        Node node = new Node();
        node.data=data;
        node.next=null;
        if(head==null){
            head=node;
        }else if(index==0){
            insertAtStart(data);
        }else {
            Node n = head;
            for(int i = 0;i<index-1;i++){
                n= n.next;
            }
            node.next=n.next;
            n.next=node;
        }
    }

    public void deleteAt(int index){

        if(head==null){
            return;
        }else if(index==0){
            deleteAtFirst();
        }else {
            Node n = head;
            for(int i = 0;i<index-1;i++){
                n= n.next;
            }
            n.next=n.next.next;
        }
    }

    public void deleteAtLast(){

        if(head==null){
            return;
        }else {
            Node n = head;
            while(n.next.next!=null) {
                n = n.next;
            }
            n.next=null;
        }
    }


    public void deleteAtFirst(){
        head=head.next;
    }



    public void display(){
        Node n=head;
        while(n.next!=null){
            System.out.println(n.data);
            n=n.next;
        }
        System.out.println(n.data);
    }
}
