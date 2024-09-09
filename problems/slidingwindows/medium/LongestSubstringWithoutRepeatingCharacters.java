package problems.slidingwindows.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String string = "bbbbb";
        int length = lengthOfLongestSubstring(string);
        System.out.println(length);

        int lengthBruteForce = lengthOfLongestSubstringBruteforce(string);
        System.out.println(lengthBruteForce);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int l = 0;
        int result = 0;

        for (int r = 0; r < s.length(); r++) {
            while (window.contains(s.charAt(r))) {
                window.remove(s.charAt(l));
                l += 1;
            }
            window.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
        }

        return result;
    }

    /**
     * Time: O(n^3)
     * Space: O(n)
     */
    public static int lengthOfLongestSubstringBruteforce(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }

        return maxLength;
    }

    private static boolean allUnique(String s, int start, int end) {
        boolean[] charSet = new boolean[128];
        for (int i = start; i < end; i++) {
            if (charSet[s.charAt(i)]) {
                return false;
            }
            charSet[s.charAt(i)] = true;
        }
        return true;
    }
}
