package problems.arrays.easy;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String string = "luffy is still joyboy";
        int lengthOfLastWord = lengthOfLastWord(string);
        System.out.println(lengthOfLastWord);
    }

    public static int lengthOfLastWord(String s) {
        String string = s.trim();

        int startOfLastWord = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ' && Character.isLetter(string.charAt(i + 1)) ) {
                startOfLastWord = i + 1;
            }
        }

        return string.length() - startOfLastWord;
    }

}
