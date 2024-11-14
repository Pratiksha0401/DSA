package org.example.demo;

interface A{
    void show();
}

interface B{
    void display();
}

class W implements  A,B{

    @Override
    public void show() {
        System.out.println("in show");
    }

    @Override
    public void display() {
        System.out.println("in display");
    }
}
public class Interfaces {
    public static void main(String[] args) {
        B w = new W();
        w.display();
        A a = new W();
        a.show();

        W w1= new W();
        w1.display();
        w1.show();
    }

}
