/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) return result;

        dfs(root, "", result);

        return result;
    }

    public void dfs(TreeNode node, String currentPath, List<String> result) {
        if (node == null) return;

        currentPath += node.val;

        if (node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }

        currentPath += "->";

        dfs(node.left, currentPath, result);
        dfs(node.right, currentPath, result);
    }
}