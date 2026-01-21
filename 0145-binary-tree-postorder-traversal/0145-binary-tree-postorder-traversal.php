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
    function postorderTraversal($root) {
        $visited = [];
        $this->dfs($root, $visited);
        return $visited;
    }

    function dfs($node, &$visited) {
        if ($node == null) {
            return;
        }
        $this->dfs($node->left, $visited);
        $this->dfs($node->right, $visited);
        $visited[] = $node->val;
    }
}