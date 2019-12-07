/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal($root) {
        if(empty($root)) {
            return [];
        }
        $a = $this->inorderTraversal($root->left);
        $arr = [$root->val];
        $b = $this->inorderTraversal($root->right);
    
 
        return array_merge($a, $arr , $b);
    }
}