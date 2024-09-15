package problems.hashmaps.easy;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterToAppearTwice {
    public static void main(String[] args) {
        char repeatedCharacter = repeatedCharacter("abccbaacz");
        System.out.println(repeatedCharacter);

        char repeatedCharacterOptimal = repeatedCharacterOptimal("abccbaacz");
        System.out.println(repeatedCharacterOptimal);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public static char repeatedCharacter(String s) {
        Set<Character> characters = new HashSet<>();

        for (Character c: s.toCharArray()) {
            if (characters.contains(c)) {
                return c;
            }
            characters.add(c);
        }

        return ' ';
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static char repeatedCharacterOptimal(String s) {
        boolean[] charSeen = new boolean[26];

        for (Character c: s.toCharArray()) {
            if (charSeen[c - 'a']) {
                return c;
            }
            charSeen[c - 'a'] = true;
        }

        return ' ';
    }

}
