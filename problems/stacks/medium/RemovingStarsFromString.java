package problems.stacks.medium;

import java.util.Stack;

public class RemovingStarsFromString {
    public static void main(String[] args) {
        String string = "leet**cod*e";
        String stringWithoutStars = removeStars(string);
        System.out.println(stringWithoutStars);
        System.out.println(removeStarsOptimal(stringWithoutStars));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public static String removeStarsOptimal(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!result.isEmpty()) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
