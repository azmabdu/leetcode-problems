package problems.twopointers.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquaresOptimal(nums)));
        System.out.println(Arrays.toString(sortedSquaresBruteForce(nums)));
    }

    /**
     * Space: O(n)
     * Time: O(n)
     */
    public static int[] sortedSquaresOptimal(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;

        while (left <= right) {
            int leftPowered = nums[left] * nums[left];
            int rightPowered = nums[right] * nums[right];

            if (leftPowered > rightPowered) {
                result[index--] = leftPowered;
                left++;
            } else {
                result[index--] = rightPowered;
                right--;
            }
        }

        return result;
    }

    /**
     * Time: O(n2)
     * Space: O(1)
     */
    private static int[] sortedSquaresBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
}
