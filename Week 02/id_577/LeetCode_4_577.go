/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
    
    if root == nil {
        return nil 
    }
    
    if root.Left == nil &&  root.Right == nil {
        return []int{root.Val}
    }
    
    traversal_path := []int{root.Val}
    
    traversal_path = append(traversal_path, preorderTraversal(root.Left)...)
    
    traversal_path = append( traversal_path, preorderTraversal(root.Right)...)
    
    return  traversal_path
    
}