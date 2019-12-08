/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func isValidBST(root *TreeNode) bool {
    
  
    
    return DFS(root, nil, nil)
    
    
    
}

//Attention, notic the reference and pointer, if u don't use reference and pointer, it's difficult to exclude the first level of root , left right, ex: [1, 1], [0, null. -1]

func DFS(root *TreeNode, lower *int, upper *int) bool {
    
    if root == nil {
        return true
    }
    
    rootVal := root.Val
    
    if  lower != nil && rootVal<= *lower {
        return false 
    }
    
    if upper != nil && rootVal >= *upper{
        return false
    }
    
    
    //Next row
    
    if !DFS(root.Left, lower, &rootVal) {
        return false
    }
    
    if !DFS(root.Right, &rootVal, upper) {
        return false
    }
    
    return true
    
    
    
}