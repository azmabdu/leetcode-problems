package problems.stacks.easy;

import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    private static final List<Character> OPENING_CHARS = List.of('{', '[', '(');
    private static final List<Character> CLOSING_CHARS = List.of('}', ']', ')');

    public static void main(String[] args) {
        String input = "(]";
        boolean valid = isValid(input);
        System.out.println(valid); // Output: false
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (OPENING_CHARS.contains(currentChar)) {
                stack.push(currentChar);
            } else if (CLOSING_CHARS.contains(currentChar)) {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();

                if (!isMatchingPair(topChar, currentChar)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all opening characters had matching closing characters
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char openChar, char closeChar) {
        return (openChar == '(' && closeChar == ')') ||
               (openChar == '[' && closeChar == ']') ||
               (openChar == '{' && closeChar == '}');
    }
}