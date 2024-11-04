package problems.linkedlists.medium;

import core.ListNode;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode newHead = deleteMiddle(list1);
        System.out.println(newHead);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static ListNode deleteMiddle(ListNode head) {
        // if head is null, return the head itself
        if (head == null) {
            return null;
        }

        // Create dummy node called prev with any value, and assign next to out head
        ListNode prev = new ListNode(0);
        prev.next = head;

        // Create and assign slow pointer to prev, fast pointer to head
        ListNode slow = prev;
        ListNode fast = head;

        // Loop until fast is not null and fast.next is not null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // Remove the element next to slow
        slow.next = slow.next.next;

        // return head or prev.next
        return prev.next;
    }
}
