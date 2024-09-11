package problems.linkedlists.easy;

import core.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(middleNode(node));
        System.out.println(middleNodeBruteForce(node));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode middleNodeBruteForce(ListNode head) {
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            length += 1;
        }

        int mid = length / 2;
        int i = 0;
        while (head != null && i < mid) {
            head = head.next;
            i += 1;
        }

        return head;
    }

}
