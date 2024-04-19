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

function isSymmetric(root: TreeNode | null): boolean {
    return isMirror(root, root);
};

function isMirror(tree1: TreeNode | null, tree2: TreeNode | null): boolean {
    if (tree1 === null && tree2 === null) return true;
    if (tree1 === null|| tree2 === null) return false;
    return tree1.val === tree2.val && isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
}