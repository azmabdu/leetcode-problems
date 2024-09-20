package problems.heaps.easy;

import java.util.PriorityQueue;

public class TakeGiftsFromRichestPile {
    public static void main(String[] args) {
        int[] gifts = new int[]{25, 64, 9, 4, 100};
        long richest = pickGifts(gifts, 4);
        System.out.println(richest);
    }

    /**
     * Time: O(n + k)
     * Space: O(n)
     */
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        long sum = 0;

        for (int gift : gifts) {
            sum += gift;
            pq.offer(gift);
        }

        while (k > 0 && !pq.isEmpty()) {
            int largest = pq.poll();
            int sqrt = (int) Math.sqrt(largest);
            sum -= (largest - sqrt);
            pq.offer(sqrt);
            k -= 1;
        }

        return sum;
    }

}
