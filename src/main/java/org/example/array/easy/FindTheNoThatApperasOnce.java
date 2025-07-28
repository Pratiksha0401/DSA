package org.example.array.easy;

/**
 * This class provides different approaches to find the number that appears only once
 * in an integer array where every other number appears more than once.
 *
 * <p>Two methods are demonstrated:
 * <ul>
 *     <li><b>Using XOR:</b> XOR of two same numbers is 0, and XOR of a number with 0 is the number itself.
 *     Hence, XOR-ing all the elements results in the number that appears only once.</li>
 *     <li><b>Using Frequency Count:</b> Brute-force method where the frequency of each number is counted
 *     and the one with count 1 is printed.</li>
 * </ul>
 */
public class FindTheNoThatApperasOnce {

    /**
     * The main method to run the demonstration.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        // Using XOR approach
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        System.out.println("Unique number using XOR approach: " + xor);

        // Using Brute Force Count approach
        System.out.print("Unique number using count approach: ");
        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                System.out.println(arr[i]);
                break; // Stop after finding the unique number
            }
        }
    }
}
