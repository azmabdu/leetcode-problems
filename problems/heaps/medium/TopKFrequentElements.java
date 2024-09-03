package problems.heaps.medium;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 4, 5, 5, 5};
        int k = 2;
        int[] topKFrequent = topKFrequentWithBucketList(nums, k);
        System.out.println(Arrays.toString(topKFrequent));
    }

    public static int[] topKFrequentWithPriorityQueue(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        priorityQueue.addAll(frequency.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(priorityQueue.poll()).getKey();
        }

        return result;
    }

    public static int[] topKFrequentWithBucketList(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }

        int[] topKFrequent = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequent[i] = result.get(i);
        }

        return topKFrequent;
    }
}
