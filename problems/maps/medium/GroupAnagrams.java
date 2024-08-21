package problems.maps.medium;

import java.util.*;

/**
 * 49. Group Anagrams
 * <a href="https://leetcode.com/problems/group-anagrams">...</a>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagramsBruteForce = groupAnagrams(strings);
        List<List<String>> anagramsOptimal = groupAnagramsOptimal(strings);
        System.out.println(anagramsOptimal);
        System.out.println(anagramsBruteForce);
    }

    public static List<List<String>> groupAnagramsOptimal(String[] strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }
        // array of char occurrences: [words]
        Map<String, List<String>> map = new HashMap<>();
        for (String string: strings) {
            String currMap = countChars(string);
            map.computeIfAbsent(currMap, _ -> new ArrayList<>()).add(string);
        }
        return new ArrayList<>(map.values());
    }

    private static String countChars(String s) {
        int[] map = new int[26];
        for (Character c: s.toCharArray()) {
            map[c - 'a'] += 1;
        }
        return Arrays.toString(map);
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        // sorted word: [anagrams]
        Map<String, List<String>> anagramMap = new HashMap<>();

        if (strings == null || strings.length == 0) {
            return null;
        }

        for (String str : strings) {
            String sortedStr = sortString(str);

        //  anagramMap.computeIfAbsent(sortedStr, _ -> new ArrayList<>()).add(str);
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
