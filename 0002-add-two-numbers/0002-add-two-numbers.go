/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    temp := 0
    result := &ListNode{}
    current := result

    for l1 != nil && l2 != nil {
        sum := l1.Val + l2.Val + temp
        current.Next = &ListNode{
            Val: sum % 10,
            Next: nil,
        }
        temp = sum / 10
        l1 = l1.Next
        l2 = l2.Next
        current = current.Next
    }
    for l1 != nil {
        sum := l1.Val + temp
        current.Next = &ListNode{
            Val: sum % 10,
            Next: nil,
        }
        temp = sum / 10
        l1 = l1.Next
        current = current.Next
    }

    for l2 != nil {
        sum := l2.Val + temp
        current.Next = &ListNode{
            Val: sum % 10,
            Next: nil,
        }
        temp = sum / 10
        l2 = l2.Next
        current = current.Next
    }

    if temp > 0 {
        current.Next = &ListNode{
            Val: temp,
            Next: nil,
        }
    }

    return result.Next
}