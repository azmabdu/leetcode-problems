package problems.sets.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 219. <a href="https://leetcode.com/problems/contains-duplicate-ii">...</a>
 */
public class ContainsDuplicateTwo {
    public static void main(String[] args) {
        // Example array and value for k
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 2;

        // Check if there are any duplicates within k distance
        boolean duplicateExists = containsNearbyDuplicate(nums, k);
        // Print the result
        System.out.printf("Is duplicate number exists in array %s: k :%s result: %s", Arrays.toString(nums), k, duplicateExists);
    }

    /**
     * Determines if the array contains any duplicates within a specified distance k.
     *
     * @param nums The input array of integers
     * @param k The maximum index distance between duplicate values
     * @return true if a duplicate within the distance k is found; false otherwise
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a set to store unique numbers within the current sliding window
        Set<Integer> uniqueNumbers = new HashSet<>();
        // Initialize the left pointer of the sliding window
        int L = 0;

        // Iterate through the array with the right pointer of the sliding window
        for (int R = 0; R < nums.length; R++) {
            // If the window size exceeds k, remove the leftmost element and move the left pointer
            if (R - L > k) {
                uniqueNumbers.remove(nums[L]);
                L += 1;
            }

            // Check if the current element is already in the set, indicating a duplicate within distance k
            if (uniqueNumbers.contains(nums[R])) {
                return true; // Duplicate found within k distance
            }

            // Add the current element to the set
            uniqueNumbers.add(nums[R]);
        }

        // No duplicates within the specified distance were found
        return false;
    }
}