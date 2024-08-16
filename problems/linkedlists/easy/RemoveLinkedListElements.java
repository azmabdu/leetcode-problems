package problems.linkedlists.easy;

import core.ListNode;


/**
 * 203. Remove Linked List Elements
 * <a href="https://leetcode.com/problems/remove-linked-list-elements">...</a>
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
        node.printList(node);
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

}
