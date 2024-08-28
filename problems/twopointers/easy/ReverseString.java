package problems.twopointers.easy;

public class ReverseString {

    public static void main(String[] args) {
        char[] chars = new char[]{'A', 'z', 'i', 'm', 'j', 'o', 'n'};
        reverseString(chars);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static void reverseString(char[] s) {
        int start= 0;
        int last = s.length - 1;

        while (start < last) {
            char temp;
            temp = s[start];
            s[start] = s[last];
            s[last] = temp;

            last -= 1;
            start += 1;
        }
    }

}
