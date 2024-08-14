package problems.easy.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. ValidAnagram: <a href="https://leetcode.com/problems/valid-anagram">...</a>
 */
public class ValidAnagram {
    public static void main(String[] args) {
        boolean isAnagram1 = isAnagram("anagram", "nagaram");
        boolean isAnagram2 = isAnagram("rat", "car");

        System.out.println("Is 'anagram' an anagram of 'nagaram'? " + isAnagram1);
        System.out.println("Is 'rat' an anagram of 'car'? " + isAnagram2);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        count(count1, s);
        count(count2, t);

        return count1.equals(count2);
    }

    private static void count(Map<Character, Integer> charCountMap, String str) {
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
    }
}
