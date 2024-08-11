package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. https://leetcode.com/problems/3sum/
 *
 * This class solves the 3Sum problem, where we need to find all unique triplets in an array
 * that sum up to zero.
 */
public class ThreeSum {

    public static void main(String[] args) {
        // Example input array
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        // Get all unique triplets that sum to zero
        List<List<Integer>> list = threeSum(nums);
        // Print the result
        System.out.println(list);
    }

    /**
     * Finds all unique triplets in the array that sum up to zero.
     *
     * @param nums The input array of integers
     * @return A list of lists where each list represents a unique triplet
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // Initialize the result list
        List<List<Integer>> result = new ArrayList<>();
        // Sort the input array
        Arrays.sort(nums);

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate elements to avoid redundant triplets
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }

            // Initialize the left and right pointers
            int left = i + 1;
            int right = nums.length - 1;

            // Use two-pointer technique to find the other two elements
            while (left < right) {
                // Calculate the sum of the current triplet
                int sum = nums[i] + nums[left] + nums[right];

                // Adjust pointers based on the sum
                if (sum > 0) {
                    right -= 1; // Reduce the sum by moving the right pointer left
                } else if (sum < 0) {
                    left += 1; // Increase the sum by moving the left pointer right
                } else {
                    // Found a valid triplet
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left += 1; // Move left pointer to the right to find new triplets
                    // Skip duplicate elements to avoid redundant triplets
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                }
            }
        }

        // Return the list of unique triplets
        return result;
    }
}