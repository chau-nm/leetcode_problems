/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func goodNodes(root *TreeNode) int {
    return dfs(root, root.Val)
}

func dfs(node *TreeNode, maxSoFar int) int {
    if node == nil {
        return 0
    }

    good := 0
    if node.Val >= maxSoFar {
        good = 1
        maxSoFar = node.Val
    }

    left := dfs(node.Left, maxSoFar)
    right := dfs(node.Right, maxSoFar)

    return good + left + right
}