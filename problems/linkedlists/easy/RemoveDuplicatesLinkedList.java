package problems.linkedlists.easy;

import core.ListNode;

public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {
        var list1 = new ListNode(1);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(3);

        ListNode res = deleteDuplicates(list1);
        res.printList(res);
    }

    /**
     * Definition for singly-linked list.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        var curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return head;
    }

}
