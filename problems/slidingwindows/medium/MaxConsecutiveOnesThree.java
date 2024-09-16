package problems.slidingwindows.medium;

public class MaxConsecutiveOnesThree {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int max = 0;
        int zeros = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                while (zeros >= k) {
                    if (nums[left] == 0) {
                        zeros -= 1;
                    }
                    left += 1;
                }
                zeros += 1;
            }

            max = Math.max(right - left + 1, max);
        }

        return max;
    }
}
