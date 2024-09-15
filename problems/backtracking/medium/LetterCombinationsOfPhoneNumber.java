package problems.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    private static final String[] KEYPAD = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * Time: O(4^n) - n length of the input string, at worst number may have 4 chars like 7, 9
     * Space: O(n) - recursion and string-builder
     */
    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder currentCombination, String digits, int index) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(result, currentCombination, digits, index + 1);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = letterCombinations(digits);
        System.out.println(combinations);
    }

}
