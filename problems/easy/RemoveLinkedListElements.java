package problems.easy;

import java.awt.desktop.AppReopenedEvent;

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements
 *
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        var head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(5);

        ListNode node = removeElements(head, 1);
        printList(node);
    }

    public static ListNode removeElements(ListNode head, int val) {
        var dummy = new ListNode();
        dummy.next = head;

        var curr = dummy;

        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;  // Value of the node
        ListNode next;  // Pointer to the next node
        ListNode() {}  // Default constructor
        ListNode(int val) { this.val = val; }  // Constructor with value
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }  // Constructor with value and next node
    }

    public static void printList(ListNode head) {
        // Traverse through the linked list and print each node's value
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;  // Move to the next node
        }
    }

}
