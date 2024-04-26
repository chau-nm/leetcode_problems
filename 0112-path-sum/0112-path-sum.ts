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

function hasPathSum(root: TreeNode | null, targetSum: number): boolean {
    if (root === null) return false;
    if (root.left === null && root.right === null) {
        return root.val === targetSum;
    }
    return scan(root, root.val, targetSum);
}

function scan(root: TreeNode, currentTotal: number, targetSum: number): boolean {
    if (currentTotal === targetSum && !root.left && !root.right) {
        return true;
    }
    let leftResult = false;
    let rightResult = false;
    if (root.left !== null) {
        leftResult = scan(root.left, currentTotal + root.left.val, targetSum);
    }
    if (root.right !== null) {
        rightResult = scan(root.right, currentTotal + root.right.val, targetSum);
    }
    return leftResult || rightResult;
}