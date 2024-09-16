package problems.slidingwindows.medium;

public class MaxConsecutiveOnesTwo {
    public static void main(String[] args) {
        int[] nums = new int[] {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxConsecutive = Math.max(maxConsecutive, right - left + 1);
        }

        return maxConsecutive;
    }
}
