package problems.heaps.easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[] {2,7,4,1,8,1}));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int firstLargest = maxHeap.poll();
            int secondLargest = maxHeap.poll();

            if (firstLargest != secondLargest) {
                maxHeap.offer(firstLargest - secondLargest);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
