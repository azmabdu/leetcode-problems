package problems.easy;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        // Test string to check if it's a palindrome
        String s = "A man, a plan, a canal: Panama";

        // Call the isPalindrome method and store the result
        boolean isPalindrome = isPalindrome(s);

        // Print the result to the console
        System.out.println(isPalindrome);
    }

    // Method to determine if a given string is a palindrome
    public static boolean isPalindrome(String s) {
        int left, right;
        left = 0; // Initialize left pointer at the start of the string
        right = s.length() - 1; // Initialize right pointer at the end of the string

        // Convert the entire string to lowercase for case-insensitive comparison
        String lowercased = s.toLowerCase();

        // Loop until the left pointer crosses the right pointer
        while (left <= right) {
            // If the current left character is not alphanumeric, move the left pointer to the right
            if (!Character.isLetterOrDigit(lowercased.charAt(left))) {
                left += 1;
                // If the current right character is not alphanumeric, move the right pointer to the left
            } else if (!Character.isLetterOrDigit(lowercased.charAt(right))) {
                right -= 1;
                // If both characters are alphanumeric, compare them
            } else {
                // If the characters don't match, the string is not a palindrome
                if (lowercased.charAt(left) != lowercased.charAt(right)) {
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