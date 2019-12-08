/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
class Solution {
    func minDepth(_ root: TreeNode?) -> Int {
        if root == nil { return 0 }
        let ld = minDepth(root?.left)
        let rd = minDepth(root?.right)
        return root?.left == nil || root?.right == nil ? ld + rd + 1 : min(ld, rd) + 1
    }
}