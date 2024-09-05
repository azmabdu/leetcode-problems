package problems.heaps.medium;

import java.util.*;

/**
 * Input: positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is not studious","the student is smart"], student_id = [1,2], k = 2
 * Output: [2,1]
 * Explanation:
 * - The student with ID 1 has 1 positive feedback and 1 negative feedback, so he has 3-1=2 points.
 * - The student with ID 2 has 1 positive feedback, so he has 3 points.
 * Since student 2 has more points, [2,1] is returned.
 */
public class RewardTopKStudents {

    public static void main(String[] args) {
        String[] positiveFeedbacks = new String[] {"smart","brilliant","studious"};
        String[] negativeFeedbacks = new String[] {"not"};
        String[] report = new String[] {"this student is not studious","the student is smart"};
        int[] studentId = new int[] {1,2};

        List<Integer> points = topStudents(positiveFeedbacks, negativeFeedbacks, report, studentId, 3);
        System.out.println(points);
    }

    public static List<Integer> topStudents(String[] positiveFeedbacks, String[] negativeFeedbacks, String[] report, int[] studentId, int k) {
        Set<String> positiveFeedbackSet = new HashSet<>(Arrays.asList(positiveFeedbacks));
        Set<String> negativeFeedbackSet = new HashSet<>(Arrays.asList(negativeFeedbacks));

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return a.getKey() - b.getKey();
            } else {
                return b.getValue() - a.getValue();
            }
        });
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < studentId.length; i++) {
            Integer points = countStudentPoints(positiveFeedbackSet, negativeFeedbackSet, report[i]);
            pq.add(new AbstractMap.SimpleEntry<>(studentId[i], points));
        }

        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                result.add(pq.poll().getKey());
            }
        }

        return result;
    }

    private static Integer countStudentPoints(Set<String> positiveFeedbacks, Set<String> negativeFeedbacks, String report) {
        int points = 0;

        String[] words = report.split(" ");

        for (String word: words) {
            if (positiveFeedbacks.contains(word)) {
                points += 3;
            } else if (negativeFeedbacks.contains(word)) {
                points -= 1;
            }
        }

        return points;
    }

}
