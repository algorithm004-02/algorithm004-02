/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 //It's different from max depth.
 func minDepth(root *TreeNode) int {
    
    if root == nil {
        return 0
    }
    
    if root.Left == nil && root.Right == nil{
        return 1
    }
    
   
    
    min_depth := int(^uint(0) >> 1) 
   
    
    if root.Left != nil {
        
        min_depth = min(minDepth(root.Left), min_depth)

    } 
    
    
    if root.Right != nil {
        
        min_depth = min(minDepth(root.Right), min_depth)
    
        
    }
    
    return min_depth + 1
    
}

func min(x, y int) int {
    if  x < y  {
        return x
    }
    
    return y
}