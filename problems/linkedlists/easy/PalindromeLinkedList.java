package problems.linkedlists.easy;

import core.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);

        boolean isPalindrome = isPalindrome(node);
        System.out.println(isPalindrome);

    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        int value;
        while (!stack.isEmpty() && slow != null) {
            value = stack.pop();
            if (value != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return stack.isEmpty();
    }

    public static boolean isPalindromeReverse(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = secondHalfHead;

        boolean isPalindrome = true;
        while (secondHalfPointer != null) {
            if (firstHalfPointer.val != secondHalfPointer.val) {
                isPalindrome = false;
                break;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        return isPalindrome;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
