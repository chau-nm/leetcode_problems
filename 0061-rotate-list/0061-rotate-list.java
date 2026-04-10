/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int length = getLength(head);
        k = k % length;
        return rotate(head, k);
    }

    private ListNode rotate(ListNode head, int k) {
        if (k == 0) return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        curr.next = head;

        return rotate(curr, k - 1);
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}