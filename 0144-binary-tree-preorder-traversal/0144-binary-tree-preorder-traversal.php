/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($val = 0, $left = null, $right = null) {
 *         $this->val = $val;
 *         $this->left = $left;
 *         $this->right = $right;
 *     }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal($root) {
        $visited = [];
        $this->dfs($root, $visited);
        return $visited;
    }

    function dfs($tree, &$visited) {
        if ($tree == null) {
            return;
        }
        $visited[] = $tree->val;
        $this->dfs($tree->left, $visited);
        $this->dfs($tree->right, $visited);
    }
}