package problems.arrays.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumProductOfTwoElements {
    public static void main(String[] args) {
        int maxProduct = maxProductHeap(new int[]{3, 4, 5, 2});
        System.out.println(maxProduct);
    }

    public static int maxProduct(int[] nums) {
        int max = 0;
        int product;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                product = (nums[i] - 1) * (nums[j] - 1);
                max = Math.max(product, max);
            }
        }

        return max;
    }

    public static int maxProductSorting(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static int maxProductHeap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int num : nums) {
            maxHeap.offer(num);
        }

        if (maxHeap.size() < 2) {
            return 0;
        }

        int num1 = maxHeap.poll();
        int num2 = maxHeap.poll();

        return (num1 - 1) * (num2 - 1);
    }
}
