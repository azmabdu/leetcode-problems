package problems.linkedlists.medium;

import core.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        ListNode result = removeNthFromEnd(list1, 2);
        System.out.println(result);

        ListNode result1 = removeNthFromEndBruteForce(list1, 2);
        System.out.println(result1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEndBruteForce(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int positionToRemove = length - n;

        if (positionToRemove == 0) {
            return head.next;
        }

        temp = head;
        for (int i = 1; i < positionToRemove; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

}
