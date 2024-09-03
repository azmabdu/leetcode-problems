package problems.heaps.medium;

import java.util.*;

/**
 * nums = [3,2,1,5,6,4], k = 2
 */
public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};
        int kthLargest = findKthLargestWithHeap(nums, 2);
        System.out.println(kthLargest);
    }

    public static int findKthLargestWithSorting(int[] nums, int k) {
        Arrays.sort(nums);

        for (int num : nums) {
            if (num >= nums[nums.length - k]) {
                return nums[nums.length - k];
            }
        }

        return 0;
    }

    public static int findKthLargestWithHeap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}
