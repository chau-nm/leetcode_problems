/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func diameterOfBinaryTree(root *TreeNode) int {
    maxDiameter := 0
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

        maxDiameter = max(maxDiameter, leftDepth + rightDepth)

        if leftDepth > rightDepth {
            return leftDepth + 1
        }
        return rightDepth + 1
    }
    depth(root)

    return maxDiameter
}