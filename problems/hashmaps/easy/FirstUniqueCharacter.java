package problems.hashmaps.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        int uniqueCharIndex = firstUniqChar("leetcode");
        System.out.println(uniqueCharIndex);

        int uniqueCharIndexOptimal = firstUniqCharOptimal("leetcode");
        System.out.println(uniqueCharIndexOptimal);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> count = new LinkedHashMap<>();

        for (Character c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static int firstUniqCharOptimal(String s) {
        int[] charCount = new int[26];

        for (Character c: s.toCharArray()) {
            charCount[c - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
