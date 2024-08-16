package problems.sets.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. <a href="https://leetcode.com/problems/contains-duplicate">...</a>
 * This class provides a solution for the "Contains Duplicate" problem, where the goal is to determine
 * if there are any duplicate elements in an array.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        // Test arrays with and without duplicates
        int[] numsWithDuplicates = new int[]{1, 2, 2, 3, 4, 5};
        int[] numsWithoutDuplicates = new int[]{1, 2, 3, 4, 5};

        // Check for duplicates in the array with duplicates
        boolean bool = containsDuplicate(numsWithDuplicates);
        // Print the result for the array with duplicates
        System.out.printf("\nIs array contains duplicate %s : %s", Arrays.toString(numsWithDuplicates), bool);

        // Check for duplicates in the array without duplicates
        bool = containsDuplicate(numsWithoutDuplicates);
        // Print the result for the array without duplicates
        System.out.printf("\nIs array contains duplicate %s : %s", Arrays.toString(numsWithoutDuplicates), bool);
    }

    /**
     * Determines if the given array contains any duplicate elements.
     *
     * @param nums The input array of integers
     * @return true if there is at least one duplicate element; false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        // Create a set to track unique elements
        Set<Integer> numbers = new HashSet<>();

        // Iterate through the array
        for (Integer num: nums) {
            // If the number is already in the set, a duplicate has been found
            if (numbers.contains(num)) {
                return true;
            }
            // Add the number to the set
            numbers.add(num);
        }

        // No duplicates found
        return false;
    }
}