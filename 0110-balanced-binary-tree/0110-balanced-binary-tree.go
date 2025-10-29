/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    balanced := true

    var depth func(tree *TreeNode) int
    depth = func(tree *TreeNode) int {
        if tree == nil {
            return 0
        }
        if tree.Left == nil && tree.Right == nil {
            return 1
        }

        leftDepth := depth(tree.Left)
        rightDepth := depth(tree.Right)

        determine := abs(rightDepth - leftDepth)
        if determine > 1 {
            balanced = false
        }
        if leftDepth > rightDepth {
            return leftDepth + 1
        }
        return rightDepth + 1
    }

    depth(root)
    return balanced
}

func abs(num1 int) int {
    if num1 < 0 {
        return -num1
    } else {
        return num1
    }
}