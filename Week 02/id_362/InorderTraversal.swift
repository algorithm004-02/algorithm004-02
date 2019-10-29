class Solution {
    func inorderTraversal(_ root: ListNode?) -> [Int] {
        guard let root = root else { return [ ] }
        return inorderTraversal(root.left) + [root.val] + inorderTraversal(root.right)
    }
}
