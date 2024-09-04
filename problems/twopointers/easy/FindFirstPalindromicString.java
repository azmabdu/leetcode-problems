package problems.twopointers.easy;

public class FindFirstPalindromicString {
    public static void main(String[] args) {
        String[] words = new String[] {"abc","car","ada","racecar","cool"};
        String first = firstPalindrome(words);
        System.out.println(first);
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }

    private static boolean isPalindrome(String s) {
        int left, right;
        left = 0; // Initialize left pointer at the start of the string
        right = s.length() - 1; // Initialize right pointer at the end of the string

        // Loop until the left pointer crosses the right pointer
        while (left <= right) {
            // If the current left character is not alphanumeric, move the left pointer to the right
            if (!Character.isLetterOrDigit(Character.toLowerCase(s.charAt(left)))) {
                left += 1;
                // If the current right character is not alphanumeric, move the right pointer to the left
            } else if (!Character.isLetterOrDigit(Character.toLowerCase(s.charAt(right)))) {
                right -= 1;
                // If both characters are alphanumeric, compare them
            } else {
                // If the characters don't match, the string is not a palindrome
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                // Move both pointers towards the center
                left += 1;
                right -= 1;
            }
        }

        // If all characters matched, the string is a palindrome
        return true;
    }
}
