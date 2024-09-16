package problems.arrays.easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == 1) {
                count += 1;
            } else if (nums[i] == 0) {
                count = 0;
            }
            maxCount = Math.max(count, maxCount);
            i += 1;
        }

        return maxCount;
    }
}
