package problems.linkedlists.medium;

import core.ListNode;

public class SwappingNodesInLinkedList {
    /**
     * You are given the head of a linked list, and an integer k.
     * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [1,4,3,2,5]
     */
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        ListNode result = swapNodes(list1, 2);
        System.out.println(result);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        var fast = head;
        var slow = head;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        var first = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        int val = slow.val;
        slow.val = first.val;
        first.val = val;

        return head;
    }
}
