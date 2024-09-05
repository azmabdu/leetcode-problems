package problems.heaps.easy;

import java.util.*;

public class RelativeRanks {
    /**
     * Input: score = [5,4,3,2,1]
     * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
     * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
     */
    private static final String[] RANKS = new String[]{"Gold Medal","Silver Medal","Bronze Medal"};

    public static void main(String[] args) {
        int[] scores = new int[] {10,3,8,9,4};
        String[] relativeRanks = findRelativeRanks(scores);
        System.out.println(Arrays.toString(relativeRanks));
    }

    public static String[] findRelativeRanks(int[] scores) {
        // position: score
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        String[] ranks = new String[scores.length];

        for (int i = 0; i < scores.length; i++) {
            pq.add(new AbstractMap.SimpleEntry<>(i, scores[i]));
        }

        int place = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();

            switch (place) {
                case 0 -> ranks[entry.getKey()] = RANKS[0];
                case 1 -> ranks[entry.getKey()] = RANKS[1];
                case 2 -> ranks[entry.getKey()] = RANKS[2];
                default -> ranks[entry.getKey()] = String.valueOf(place + 1);
            }

            place += 1;
        }

        return ranks;
    }
}
