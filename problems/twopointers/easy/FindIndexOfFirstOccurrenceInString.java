package problems.twopointers.easy;

public class FindIndexOfFirstOccurrenceInString {
    public static void main(String[] args) {
        int i = strStr("sadbutsad", "sad");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (haystackLength < needleLength) {
            return -1;
        }

        for (int p1 = 0; p1 <= haystackLength - needleLength; p1++) {
            int p2 = 0;
            while (p2 < needle.length() && haystack.charAt(p1 + p2) == needle.charAt(p2)) {
                p2 += 1;
            }
            if (p2 == needle.length()) {
                return p1;
            }
        }

        return -1;
    }

}
