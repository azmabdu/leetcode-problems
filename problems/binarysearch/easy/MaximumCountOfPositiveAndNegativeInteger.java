package problems.binarysearch.easy;

public class MaximumCountOfPositiveAndNegativeInteger {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,-1,-1,1,2,3};
        int maximumCount = maximumCount(nums);
        System.out.println(maximumCount);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static int maximumCount(int[] nums) {
        int positive = 0;
        int negative = 0;

        for (int num : nums) {
            if (num > 0) {
                positive += 1;
            } else if (num < 0) {
                negative += 1;
            }
        }

        return Math.max(positive, negative);
    }
}
