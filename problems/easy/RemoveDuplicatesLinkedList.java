package problems.easy;

public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {
        var list1 = new ListNode(1);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(3);

        ListNode res = deleteDuplicates(list1);
        printList(res);
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {this.val = val;this.next = next;}
    }

    public static void printList(ListNode head) {
        // Traverse through the linked list and print each node's value
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;  // Move to the next node
        }
    }

}
