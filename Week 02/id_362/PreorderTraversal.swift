class Solution {
    func preorderTraversal(_ root: ListNode?) -> [Int] {
        guard let root = root else { return [ ] }
        return [root.val] + preorderTraversal(root.left) + preorderTraversal(root.right)
    }
}
