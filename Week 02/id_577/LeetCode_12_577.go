/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var inMap map[int]int

var preindex int
    
func buildTree(preorder []int, inorder []int) *TreeNode {
    
    //The first item of preorder is always the root, and the left subtree is in the inorder from  left, and the rightsubtree is in the inorder from right.
    
    inMap = make(map[int]int, len(preorder))
    
    preindex = 0
    
    for i:=0; i< len(inorder); i ++ {
        inMap[inorder[i]] = i
    }
    
    return buildSubTree(0, len(preorder), preorder)
    
    
    
    
}

func buildSubTree(left int , right int,  preorder []int) *TreeNode{
    
    if left >= right{
        return nil
    }
    
    //Get the root index
    
    root := &TreeNode{Val: preorder[preindex]}
    
    index := inMap[preorder[preindex]]
    
    preindex ++ 
    
   
    
    
    
    //build left tree 
    
    root.Left = buildSubTree(left, index, preorder)
    
    //build right tree
    
    root.Right = buildSubTree(index+1, right, preorder)
    
    return root
    
    
    
    
    
}