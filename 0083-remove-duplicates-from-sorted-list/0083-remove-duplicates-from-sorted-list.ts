/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function deleteDuplicates(head: ListNode | null): ListNode | null {
   let current = head;

    while(current !== null){
        if(current.next !== null){
            if(current.val === current.next.val){
                current.next = current.next.next;
                continue;
            }
        }

        current = current.next;
    }

    return head;
};