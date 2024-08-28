package problems.maths.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
    public static void main(String[] args) {
        int[] p1 = {2, 3};
        int[] p2 = {2, 6};
        int[] p3 = {5, 6};
        int[] p4 = {5, 3};

        boolean isSquare = validSquare(p1, p2, p3, p4);
        System.out.println(isSquare);
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> lengths = new HashSet<>();

        lengths.add(distSquared(p1, p2));
        lengths.add(distSquared(p1, p3));
        lengths.add(distSquared(p1, p4));
        lengths.add(distSquared(p2, p3));
        lengths.add(distSquared(p2, p4));
        lengths.add(distSquared(p3, p4));

        return !lengths.contains(0) && lengths.size() == 2;
    }

    private static Integer distSquared(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
