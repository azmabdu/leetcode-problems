package problems.arrays.easy;

import java.util.Arrays;

/**
 * 560. <a href="https://leetcode.com/problems/subarray-sum-equals-k">...</a>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        int subArrays = subarraySumBruteForce(nums, k);

        System.out.printf("Array %s contains %d sub arrays that equals to %d", Arrays.toString(nums), subArrays, k);
    }

    public static int subarraySumBruteForce(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    result += 1;
                }
            }
        }
        return result;
    }
}