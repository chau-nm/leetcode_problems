/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function isBalanced(root: TreeNode | null): boolean {
    let obj = {isBalanced: true};
    dfs(root, obj);
    return obj.isBalanced;
};

function dfs(root: TreeNode | null, obj: {isBalanced: boolean}): number {
    if (!root) return 0;
    const leftDepth = dfs(root.left, obj);
    const rightDepth = dfs(root.right, obj);
    if (Math.abs(leftDepth - rightDepth) > 1) obj.isBalanced = false;
    return Math.max(leftDepth + 1, rightDepth + 1);
}