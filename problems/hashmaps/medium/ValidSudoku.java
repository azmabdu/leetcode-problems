package problems.hashmaps.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {
    public static void main(String[] args) {
        List<String[]> sudoku =  new ArrayList<>();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;  // Last index of nums1

        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];  // Place the larger element at the end of nums1
                m -= 1;  // Move the pointer in nums1
            } else {
                nums1[last] = nums2[n - 1];  // Place the larger element at the end of nums1
                n -= 1;  // Move the pointer in nums2
            }
            last -= 1;  // Move the last index pointer
        }

        // If there are still elements left in nums2, place them in nums1
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n -= 1;
            last -= 1;
        }
    }
}
