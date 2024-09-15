package problems.backtracking.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> result = permute(new int[]{1, 2, 3});
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> current = new ArrayList<>();
        backtrack(nums, result, current, visited, 0);
        return result;
    }

    /**
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * Time: O(N!)
     * Space: O(N)
     */
    public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, Set<Integer> visited, int index) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                current.add(nums[i]);
                visited.add(nums[i]);
                backtrack(nums, result, current, visited, index);
                current.removeLast();
                visited.remove(nums[i]);
            }
        }
    }
}
