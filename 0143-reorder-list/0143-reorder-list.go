/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode)  {
    if head == nil || head.Next == nil {
        return
    }

    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }

    secondHalf := slow.Next
    slow.Next = nil

    reversedSecond := reverse(secondHalf)

    firstHalf := head
    for reversedSecond != nil {
        nextFirst := firstHalf.Next
        nextSecond := reversedSecond.Next

        firstHalf.Next = reversedSecond
        reversedSecond.Next = nextFirst

        firstHalf = nextFirst
        reversedSecond = nextSecond
    }
}

func reverse(head *ListNode) *ListNode {
    var prev *ListNode
    for head != nil {
        next := head.Next
        head.Next = prev
        prev = head
        head = next
    }
    return prev
}