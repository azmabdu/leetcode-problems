package problems.linkedlists.medium;

import core.ListNode;


public class SortLinkedList {
    public static void main(String[] args) {
        var list1 = new ListNode(4);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(1);
        list1.next.next.next = new ListNode(2);
        list1.next.next.next.next = new ListNode(5);
        list1.next.next.next.next.next = new ListNode(6);
        list1.next.next.next.next.next.next = new ListNode(7);
        list1.next.next.next.next.next.next.next = new ListNode(3);

        ListNode sortedList = sortListBubbleSort(list1);
    }

    public static ListNode sortListBubbleSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean swapped;
        ListNode current;
        ListNode last = null;

        do {
            swapped = false;
            current = head;

            while (current.next != last) {
                if (current.val > current.next.val) {
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);

        return head;
    }
}
