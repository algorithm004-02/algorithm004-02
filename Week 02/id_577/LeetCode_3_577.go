/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
    
   if root == nil {
        return nil 
    }
    
    if root.Left == nil && root.Right == nil {
        return []int{root.Val}
    }
   
    
   
    
    traversal_path := append(inorderTraversal(root.Left), root.Val)
    
    traversal_path  = append(traversal_path ,inorderTraversal(root.Right)...)
    
    
    
    return traversal_path
   
    
}