/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    result := &ListNode{}
    tail := result

    for list1 != nil && list2 != nil {
        if list1.Val < list2.Val {
            tail.Next = &ListNode{
                Val: list1.Val,
                Next: &ListNode{},
            }
            list1 = list1.Next
        } else {
            tail.Next = &ListNode{
                Val: list2.Val,
                Next: &ListNode{},
            }
            list2 = list2.Next
        }

        tail = tail.Next
    }

    if list1 != nil {
        tail.Next = list1
    } else if list2 != nil {
        tail.Next = list2
    }

    return result.Next
}