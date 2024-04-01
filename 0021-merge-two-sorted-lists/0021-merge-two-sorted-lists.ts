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

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
    const dummy = new ListNode(-1);
    let list1Current = list1;
    let list2Current = list2;
    let current = dummy;
    while (list1Current !== null && list2Current !== null) {
        if (list1Current.val < list2Current.val) {
            current.next = list1Current;
            list1Current = list1Current.next;
        } else {
            current.next = list2Current;
            list2Current = list2Current.next;
        }
        current = current.next;
    }
    if (list1Current !== null) {
        current.next = list1Current;
    }
    if (list2Current !== null) {
        current.next = list2Current;
    }
    return dummy.next;
};