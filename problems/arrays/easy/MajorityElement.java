package problems.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int element = majorityElementOptimal(nums);
        System.out.println(element);

        int elementBruteForce = majorityElement(nums);
        System.out.println(elementBruteForce);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > majorityCount) {
                return num;
            }
        }

        return -1;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static int majorityElementOptimal(int[] nums) {
        int res = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += num == res ? 1 : -1;
        }

        return res;
    }
}
