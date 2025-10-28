/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode {
    var result *ListNode
    for _, list := range lists {
        result = merge(result, list)
    }    
    return result
}

func merge(list1 *ListNode, list2 *ListNode) *ListNode {
    list1Current := list1
    list2Current := list2
    result := &ListNode{}
    resultCurrent := result

    for list1Current != nil && list2Current != nil {
        if list1Current.Val < list2Current.Val {
            resultCurrent.Next = &ListNode{
                Val: list1Current.Val,
                Next: nil,
            }
            list1Current = list1Current.Next
            resultCurrent = resultCurrent.Next
        } else {
            resultCurrent.Next = &ListNode{
                Val: list2Current.Val,
                Next: nil,
            }
            list2Current = list2Current.Next
            resultCurrent = resultCurrent.Next
        }
    }

    if list1Current != nil {
        resultCurrent.Next = list1Current
    }
    if list2Current != nil {
        resultCurrent.Next = list2Current
    }

    return result.Next
}