package problems.arrays.easy;

public class MajorityLetter {
    public static void main(String[] args) {
        String s = "aaabbbaacbbbccc";
        char ch = majorityLetter(s.toCharArray());
        System.out.println(ch);
    }

    public static char majorityLetter(char[] chars) {
        char res = ' ';
        int count = 0;

        for (char c : chars) {
            if (count == 0) {
                res = c;
            }
            count += (c == res) ? 1 : -1;
        }

        return res;
    }
}
