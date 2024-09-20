package problems.heaps.medium;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    public static void main(String[] args) {
        int[] piles = new int[]{4,3,6,7};
        System.out.println(minStoneSum(piles, 3));
    }

    /**
     * Time: O(n + klogn)
     * Space: O(n)
     */
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);

        int res = 0;
        for (int a : piles) {
            pq.add(a);
            res += a;
        }

        while (k > 0 && !pq.isEmpty()) {
            int a = pq.poll();
            pq.add(a - a / 2);
            res -= a / 2;
            k -= 1;
        }

        return res;
    }
}
