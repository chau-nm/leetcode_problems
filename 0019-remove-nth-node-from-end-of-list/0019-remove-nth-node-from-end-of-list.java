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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeLength = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            nodeLength++;
        }

        if (n >= nodeLength) {
            return head.next;
        }

        ListNode previousNode = head;
        current = previousNode.next;
        int idx = 0;

        while (idx < nodeLength - n - 1 && current != null) {
            idx++;
            previousNode = current;
            current = previousNode.next;
        }

        previousNode.next = current != null ? current.next : null;

        return head;
    }
}