package org.example.demo;

/**
 * Interface A defines a contract with a single method {@link #show()}.
 * Classes implementing this interface must provide their own definition
 * of the show() behavior.
 */
interface A {
    /**
     * Method to demonstrate functionality for interface A.
     */
    void show();
}

/**
 * Interface B defines a contract with a single method {@link #display()}.
 * Classes implementing this interface must provide their own definition
 * of the display() behavior.
 */
interface B {
    /**
     * Method to demonstrate functionality for interface B.
     */
    void display();
}

/**
 * Class W implements both interfaces {@link A} and {@link B}.
 *
 * This demonstrates how a single class in Java can implement multiple interfaces,
 * thereby supporting multiple inheritance of type (not implementation).
 *
 * In this example:
 * - {@link #show()} is the implementation of interface A's method.
 * - {@link #display()} is the implementation of interface B's method.
 */
class W implements A, B {

    /**
     * Prints a message indicating that the show() method of interface A
     * has been implemented in class W.
     */
    @Override
    public void show() {
        System.out.println("in show");
    }

    /**
     * Prints a message indicating that the display() method of interface B
     * has been implemented in class W.
     */
    @Override
    public void display() {
        System.out.println("in display");
    }
}

/**
 * Demonstrates how a single class can implement multiple interfaces
 * and how the same object can be referenced by different interface types.
 *
 * <p>In this example:
 * <ul>
 *   <li>Reference of type {@link B} calls only display().</li>
 *   <li>Reference of type {@link A} calls only show().</li>
 *   <li>Reference of type {@link W} can call both show() and display().</li>
 * </ul>
 *
 * This illustrates the flexibility and abstraction provided by interfaces.
 */
public class Interfaces {
    public static void main(String[] args) {
        // Object referred by interface type B
        B w = new W();
        w.display();

        // Object referred by interface type A
        A a = new W();
        a.show();

        // Object referred by class type W
        W w1 = new W();
        w1.display();
        w1.show();
    }
}
