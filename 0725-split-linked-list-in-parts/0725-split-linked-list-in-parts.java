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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int nodeLength = 0;
        ListNode current = head;
        while (current != null) {
            nodeLength++;
            current = current.next;
        }
        int partSize = nodeLength / k;
        int remainSize = nodeLength % k;
        current = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            int size = partSize + (remainSize-- > 0 ? 1 : 0);
            for (int j = 0; j < size - 1 && current != null; j++) {
                current = current.next;
            }
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
            result[i] = partHead;
        }
        return result;
    }
}