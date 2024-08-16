package problems.arrays.easy;

import java.util.Arrays;

public class MergeSortedArray {
    /**
     * 88. problems.arrays.easy.MergeSortedArray - <a href="https://leetcode.com/problems/merge-sorted-array/description/">...</a>
     * The problem requires merging two sorted arrays into one sorted array.
     * 1. Brute-force method:
     *    - Combine all elements from nums2 into nums1.
     *    - Sort nums1 after combining to get the final sorted array.
     * 2. Optimal method:
     *    - Since nums1 has a total length of m + n, where the last n elements are zeroes,
     *      we can start filling nums1 from the end.
     *    - Compare the largest elements from nums1 and nums2, and place the larger one
     *      at the end of nums1.
     *    - Continue this process, and if there are any remaining elements in nums2,
     *      place them in the beginning of nums1.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        mergeOptimal(nums1, 3, nums2, 3);
//        mergeBruteForce(nums1, 3, nums2, 3);
    }

    /**
     * Brute-force method to merge two sorted arrays.
     *
     * @param nums1 The first sorted array with extra space for nums2.
     * @param m The number of elements in nums1 (excluding extra space).
     * @param nums2 The second sorted array.
     * @param n The number of elements in nums2.
     */
    public static void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        // Copy elements from nums2 into the extra space in nums1
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        // Sort the combined array to get the final sorted result
        Arrays.sort(nums1);
    }

    /**
     * Optimal method to merge two sorted arrays.
     *
     * @param nums1 The first sorted array with extra space for nums2.
     * @param m The number of elements in nums1 (excluding extra space).
     * @param nums2 The second sorted array.
     * @param n The number of elements in nums2.
     */
    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;  // Last index of nums1

        // Start from the end of nums1 and nums2 and fill nums1 from the end
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];  // Place the larger element at the end of nums1
                m -= 1;  // Move the pointer in nums1
            } else {
                nums1[last] = nums2[n - 1];  // Place the larger element at the end of nums1
                n -= 1;  // Move the pointer in nums2
            }
            last -= 1;  // Move the last index pointer
        }

        // If there are still elements left in nums2, place them in nums1
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n -= 1;
            last -= 1;
        }
    }
}