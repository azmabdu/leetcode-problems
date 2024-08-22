package problems.linkedlists.easy;

import core.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        // Creating a simple linked list: 1 -> 2 -> 3 -> 4 -> 5
        var list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        // Reversing the linked list iteratively and printing the result
        ListNode node1 = reverseListIterative(list1);
        ListNode.printList(node1);

        // Reversing the linked list recursively (currently commented out)
        // ListNode node2 = reverseListNodeRecursive(list1);
        // node2.printList(node2);
    }

    // Method to reverse a linked list iteratively
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;  // Initially, previous node is null
        ListNode curr = head;  // Start with the head node

        // Traverse through the list
        while (curr != null) {
            var nxt = curr.next;  // Store the next node
            curr.next = prev;     // Reverse the current node's pointer
            prev = curr;          // Move the previous node to the current node
            curr = nxt;           // Move to the next node in the list
        }

        return prev;  // Return the new head of the reversed list
    }

    // Method to reverse a linked list recursively
    public static ListNode reverseListNodeRecursive(ListNode head) {
        if (head == null) {  // Base case: if the list is empty, return null
            return null;
        }

        var newHead = head;  // Initialize newHead as the current head
        if (head.next != null) {  // If there's more than one node in the list
            newHead = reverseListNodeRecursive(head.next);  // Recurse to the next node
            head.next.next = head;  // Reverse the current node's pointer
        }

        head.next = null;  // Set the next pointer of the original head to null
        return newHead;  // Return the new head of the reversed list
    }
}