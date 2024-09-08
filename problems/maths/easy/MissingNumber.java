package problems.maths.easy;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[] {9,6,4,2,3,5,7,0,1};
        int missingNumber = missingNumber(nums);
        System.out.println(missingNumber);
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int num: nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
