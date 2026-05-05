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
        if(head == null || head.next == null || k == 0) return head;
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        int rot = k % len;
        if(rot == 0) return head;
        
        curr = head;

        for(int i = 0 ; i < len - rot - 1 ; i++){
            curr = curr.next;
        }
        ListNode nHead = curr.next;
        ListNode prev = curr;

        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = head;
        head = nHead;
        prev.next = null;


        return head;
    }
}