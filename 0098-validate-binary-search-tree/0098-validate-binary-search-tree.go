/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isValidBST(root *TreeNode) bool {
    return validate(root, math.MinInt64, math.MaxInt64)
}

func validate(node *TreeNode, min, max int) bool {
    if node == nil {
        return true
    }

    if node.Val <= min || node.Val >= max {
        return false
    }

    return validate(node.Left, min, node.Val) && 
           validate(node.Right, node.Val, max)
}