package org.example.garbageCollector;

import java.util.*;

// Simulated Object class to represent objects in memory
class Object {
    boolean marked = false;  // Marking status of the object
    List<Object> references = new ArrayList<>();  // References to other objects

    // Constructor for creating an object
    public Object(List<Object> references) {
        this.references = references;
    }

    // A method to mark the object as "alive"
    public void mark() {
        marked = true;
    }

    // Method to unmark the object (for resetting between collections)
    public void unmark() {
        marked = false;
    }
}

public class MarkAndSweepGC {

    // List of all objects in memory (simulated heap)
    private List<Object> memory;

    // List of root objects (e.g., global variables, stack variables)
    private List<Object> rootObjects;

    // Constructor initializing memory and roots
    public MarkAndSweepGC(List<Object> memory, List<Object> rootObjects) {
        this.memory = memory;
        this.rootObjects = rootObjects;
    }

    // Mark phase: Traverse all root objects and mark all reachable objects
    public void markPhase() {
        Queue<Object> toVisit = new LinkedList<>();

        // Add all root objects to the queue for marking
        for (Object root : rootObjects) {
            toVisit.add(root);
        }

        // Traverse objects and mark reachable ones
        while (!toVisit.isEmpty()) {
            Object current = toVisit.poll();

            // If it's already marked, skip
            if (!current.marked) {
                current.mark();
                // Add all references (connected objects) of the current object to the queue
                for (Object ref : current.references) {
                    toVisit.add(ref);
                }
            }
        }
    }

    // Sweep phase: Traverse all objects and free those that aren't marked
    public void sweepPhase() {
        Iterator<Object> iterator = memory.iterator();

        while (iterator.hasNext()) {
            Object current = iterator.next();

            // If the object is not marked, it is garbage and should be collected (freed)
            if (!current.marked) {
                iterator.remove();  // Remove it from the "heap"
            } else {
                // Unmark the object for future collections
                current.unmark();
            }
        }
    }

    // Perform a full garbage collection (Mark + Sweep)
    public void collectGarbage() {
        markPhase();  // Step 1: Mark all reachable objects
        sweepPhase();  // Step 2: Sweep and free unmarked objects
    }

    // Example main method
    public static void main(String[] args) {
        // Create a few objects with references to each other
        Object objA = new Object(new ArrayList<>());
        Object objB = new Object(new ArrayList<>());
        Object objC = new Object(new ArrayList<>());

        // Establish references (objA -> objB -> objC)
        objA.references.add(objB);
        objB.references.add(objC);

        // Simulate memory and root objects
        List<Object> memory = new ArrayList<>();
        memory.add(objA);
        memory.add(objB);
        memory.add(objC);

        List<Object> rootObjects = new ArrayList<>();
        rootObjects.add(objA);  // objA is a root object, so it's reachable

        // Create an instance of MarkAndSweepGC
        MarkAndSweepGC gc = new MarkAndSweepGC(memory, rootObjects);

        // Run garbage collection
        System.out.println("Before garbage collection:");
        System.out.println("Memory size: " + memory.size());

        // Collect garbage (Mark and Sweep)
        gc.collectGarbage();

        System.out.println("After garbage collection:");
        System.out.println("Memory size: " + memory.size());  // Should show reduced memory size
    }
}

/**
 * GC → Automatic memory cleanup
 * Minor GC → Young Gen
 * Major GC → Old Gen
 * Full GC → Entire Heap
 * G1 → Region-based GC
 * CMS → Concurrent, deprecated
 * ZGC → Ultra-low pause GC
 * java -XX:+UseG1GC MyApp
 * java -XX:+UseZGC MyApp
 * java -XX:+PrintCommandLineFlags -version
 */