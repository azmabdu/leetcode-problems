package problems.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    /**
     * Time: O(2^n)
     * Space: O(n)
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), result, 0, 0, n);
        return result;
    }

    public static void backtrack(StringBuilder current, List<String> result, int numOpen, int numClosed, int numPairs) {
        if (numOpen == numPairs && numClosed == numPairs) {
            result.add(current.toString());
            return;
        }

        if (numOpen < numPairs) {
            current.append('(');
            backtrack(current, result, numOpen + 1, numClosed, numPairs);
            current.deleteCharAt(current.length() - 1);
        }

        if (numClosed < numOpen) {
            current.append(')');
            backtrack(current, result, numOpen, numClosed + 1, numPairs);
            current.deleteCharAt(current.length() - 1);
        }
    }
}