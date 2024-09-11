package problems.binarysearch.easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int index = search(nums, 5);
        System.out.println(index);
    }

    /**
     * Time: O(log(n))
     * Space: O(1)
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
