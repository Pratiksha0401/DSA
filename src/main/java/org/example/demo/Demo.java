package org.example.demo;

/**
 * Demo class to test inheritance and polymorphism in Java.
 *
 * <p>Key ideas demonstrated:
 * <ul>
 *   <li>A parent class reference can hold a child class object.</li>
 *   <li>Only the methods defined in the parent class are accessible
 *       through the parent reference (unless overridden).</li>
 *   <li>Child-specific methods can only be accessed using the child class reference.</li>
 * </ul>
 */
public class Demo {
    public static void main(String[] args) {
        // Parent reference pointing to child object (upcasting)
        Calculator c = new Laptop("Dell Laptop");
        System.out.println("Reference type: " + c.getClass().getSimpleName());

        // Accessible through parent reference
        c.show1();

        // Child reference to child object
        Laptop l = new Laptop("HP Laptop");
        l.show2();   // Child-specific method
        l.show1();   // Inherited method
    }
}

/**
 * Parent class representing a Calculator.
 *
 * <p>This class has a field and a method to demonstrate inheritance.
 */
class Calculator {
    private String s;    // Description

    /**
     * Constructor to initialize Calculator with a description.
     */
    public Calculator(String s) {
        this.s = s;
    }

    /**
     * Prints a message containing the description {@code s}.
     */
    public void show1() {
        System.out.println("In Calculator show1() ---- " + s + " ----");
    }
}

/**
 * Child class extending {@link Calculator}.
 *
 * <p>This demonstrates inheritance. It adds a new method
 * {@link #show2()} that is not present in the parent.
 */
class Laptop extends Calculator {

    /**
     * Constructor to initialize Laptop with a description.
     */
    public Laptop(String s) {
        super(s);
    }

    /**
     * Prints a message specific to the Laptop class.
     */
    public void show2() {
        System.out.println("In Laptop show2()");
    }
}
