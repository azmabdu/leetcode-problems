package problems.heaps.medium;

import java.util.*;

/**
 * ["the","day","is","sunny","the","the","the","sunny","is","is"]
 *
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = new String[] {"i", "love", "leetcode", "i", "love"};
        List<String> topKFrequent = topKFrequent(words, 2);
        System.out.println(topKFrequent);
    }

    /**
     * Time: O(N*log(k))
     * Space: O(N)
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(
                (w1, w2) -> {
                    int frequencyComparison = Integer.compare(frequency.get(w1), frequency.get(w2));
                    if (frequencyComparison != 0) {
                        return frequencyComparison;
                    } else {
                        return w2.compareTo(w1);
                    }
                }
        );

        for (String word : frequency.keySet()) {
            priorityQueue.offer(word);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }
        Collections.reverse(result);

        return result;
    }
}
