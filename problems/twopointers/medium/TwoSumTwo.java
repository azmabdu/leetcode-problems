package problems.twopointers.medium;

import java.util.Arrays;

public class TwoSumTwo {

    public static void main(String[] args) {
        // Example array of sorted numbers and target sum
        int[] nums = {2, 7, 11, 15};
        int target = 26;

        // Find the indices of the two numbers that add up to the target
        int[] found = twoSum2(nums, target);
        // Print the result as an array
        System.out.println(Arrays.toString(found));
    }

    /**
     * This method finds two numbers in the sorted array `numbers` that add up to the `target`.
     * It uses a two-pointer approach to efficiently find the solution.
     *
     * @param numbers the sorted array of integers
     * @param target the target sum
     * @return an array containing the 1-based indices of the two numbers
     */
    public static int[] twoSum2(int[] numbers, int target) {
        // Initialize two pointers, one at the start and one at the end of the array
        int start = 0;
        int end = numbers.length - 1;

        // Continue searching until the two pointers meet
        while (start < end) {
            // Calculate the sum of the current pair of numbers
            int sum = numbers[start] + numbers[end];

            // If the sum is greater than the target, move the end pointer to the left
            if (sum > target) {
                end -= 1;
            }
            // If the sum is less than the target, move the start pointer to the right
            else if (sum < target) {
                start += 1;
            }
            // If the sum equals the target, return the 1-based indices of the two numbers
            else {
                return new int[]{start + 1, end + 1};
            }
        }

        return new int[]{};
    }
}