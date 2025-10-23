/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    var result *ListNode

    for list1 != nil && list2 != nil {
        if list1.Val < list2.Val {
            addToLinkedList(&result, list1.Val)
            list1 = list1.Next
        } else {
            addToLinkedList(&result, list2.Val)
            list2 = list2.Next
        }
    }

    for list1 != nil {
        addToLinkedList(&result, list1.Val)
        list1 = list1.Next
    }
    for list2 != nil {
        addToLinkedList(&result, list2.Val)
        list2 = list2.Next
    }

    return result
}

func addToLinkedList(lk **ListNode, val int) {
    if *lk == nil {
        *lk = &ListNode{
            Val:  val,
            Next: nil,
        }
        return
    }

    cur := *lk
    for cur.Next != nil {
        cur = cur.Next
    }

    cur.Next = &ListNode{
        Val:  val,
        Next: nil,
    }
}