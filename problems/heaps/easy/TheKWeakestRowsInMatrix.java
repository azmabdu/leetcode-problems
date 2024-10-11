package problems.heaps.easy;

import java.util.*;

public class TheKWeakestRowsInMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };

        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }

    /**
     * Time: O(m*n + m*log m)
     * Space: O(m + n)
     */
    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue)
                        .thenComparingInt(Map.Entry::getKey)
        );

        for (int i = 0; i < mat.length; i++) {
            int numberOfSoldiers = countSoldiers(mat[i]);
            minHeap.offer(new AbstractMap.SimpleEntry<>(i, numberOfSoldiers));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    private static int countSoldiers(int[] row) {
        int count = 0;
        for (int soldier : row) {
            if (soldier == 0) {
                break;
            }
            count++;
        }
        return count;
    }
}
