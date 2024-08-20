package problems.linkedlists.medium;

import core.ListNode;

public class RemoveDuplicatesTwoLinkedList {

    public static void main(String[] args) {
        var list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(3);
        list1.next.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next.next.next = new ListNode(5);
//        list1.next.next.next.next.next.next.next.next = new ListNode(11);

        ListNode res = deleteDuplicates(list1);
        res.printList(res);
    }

    // 1 2 3 4 4 5 5 6
    public static ListNode deleteDuplicates(ListNode head) {
        var dummy = new ListNode(0, head);
        var prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
