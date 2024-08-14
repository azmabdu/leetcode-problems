package problems.easy.linkedlists;

import problems.core.ListNode;

public class MergeTwoSortedLists {
    /**
     * 21. problems.easy.linkedlist.MergeTwoSortedLists - <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">...</a>
     * Problem description:
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     *
     */

    public static void main(String[] args) {
        // Create first sorted linked list: 4 -> 7 -> 9
        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(7);
        list1.next.next = new ListNode(9);

        // Create second sorted linked list: 6 -> 8 -> 10
        ListNode list2 = new ListNode(6);
        list2.next = new ListNode(8);
        list2.next.next = new ListNode(10);

        // Merge the two sorted linked lists
        ListNode mergedList = mergeTwoLists(list1, list2);

        // Print the merged linked list
        mergedList.printList(mergedList);
    }

    // Method to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to start the merged list
        var dummy = new ListNode();
        // Start pointer initially points to the dummy node
        var start = dummy;

        // Traverse both lists until one of them is exhausted
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes of both lists
            if (list1.val < list2.val) {
                start.next = list1;  // Attach the smaller node to the merged list
                list1 = list1.next;  // Move to the next node in list1
            } else {
                start.next = list2;  // Attach the smaller node to the merged list
                list2 = list2.next;  // Move to the next node in list2
            }

            start = start.next;  // Move to the next node in the merged list
        }

        // If list1 still has nodes left, attach the rest to the merged list
        if (list1 != null) {
            start.next = list1;
        }
        // If list2 still has nodes left, attach the rest to the merged list
        else if (list2 != null) {
            start.next = list2;
        }

        // Return the head of the merged list (skip the dummy node)
        return dummy.next;
    }
}