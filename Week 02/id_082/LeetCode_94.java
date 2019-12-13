import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode-94
 * 给定一个二叉树，返回它的中序 遍历。
 */

class Solution {
	/**
	 * 通过递归，按相同方法遍历指定节点左子树，访问当前节点，遍历指定节点右子树
	 * @param root  根节点
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result);
		return result;
	}

	public void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			if (root.left != null) {
				helper(root.left, res);
			}
			res.add(root.val);
			if (root.right != null) {
				helper(root.right, res);
			}
		}
	}

	/** 通过栈先保存左子树节点，不断出栈并访问栈中元素并访问元素的右节点
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversalV2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}
}