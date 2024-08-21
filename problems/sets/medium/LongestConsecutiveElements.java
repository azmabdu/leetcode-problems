package problems.sets.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/description/">...</a>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveElements {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};  // Example input array
        int longestConsecutive = longestConsecutiveBruteForce(nums);  // Find longest consecutive sequence using brute-force method
        int longestConsecutiveOptimal = longestConsecutive(nums);  // Find longest consecutive sequence using optimal method

        System.out.println(longestConsecutive);
        System.out.println(longestConsecutiveOptimal);  // Output the result
    }

    // Function to find the longest consecutive sequence using a more optimized approach
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();  // Set to store the elements of the array
        int longest = 0;  // Variable to store the length of the longest consecutive sequence

        // Add all numbers in the array to the set
        for (int num : nums) {
            set.add(num);
        }

        // Iterate through each number in the array
        for (int num : nums) {
            int prev = num - 1;  // Previous number in the sequence

            // Check if the previous number is not in the set (start of a new sequence)
            if (!set.contains(prev)) {
                int length = 0;  // Variable to track the current sequence length

                // Count the length of the consecutive sequence starting from the current number
                while (set.contains(num + length)) {
                    length += 1;
                }

                // Update the longest sequence found so far
                longest = Math.max(longest, length);
            }
        }

        return longest;  // Return the length of the longest consecutive sequence
    }

    // Function to find the longest consecutive sequence using a brute-force approach
    public static int longestConsecutiveBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;  // Return 0 if the array is null or empty
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        int maxLength = 1;  // Variable to store the maximum length of the sequence found so far
        int currentLength = 1;  // Variable to track the current sequence length

        // Step 2: Iterate through the sorted array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                // Consecutive numbers, increase the current sequence length
                currentLength++;
            } else if (nums[i] != nums[i - 1]) {
                // Non-consecutive, reset the current sequence length
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        // Final check for the last sequence
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;  // Return the maximum length of the consecutive sequence
    }
}