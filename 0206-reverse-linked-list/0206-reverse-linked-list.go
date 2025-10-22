/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
    var result *ListNode

    for head != nil {
        if result == nil {
            result = &ListNode{
                Val: head.Val,
                Next: nil,
            }
        } else {
            resultNext := result
            result = &ListNode{
                Val: head.Val,
                Next: resultNext,
            }
        }
        head = head.Next
    }

    return result
}