/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	List<Integer> list = new ArrayList();

	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> result = new LinkedList();

		//recursion(root,result);
		iteration(root,result);
		return result;

	}

	void recursion(TreeNode root,List<Integer> result){

		if(root == null) return;
		result.add(root.val);
		recursion(root.left,result);
		recursion(root.right,result);

	}

	void iteration(TreeNode root,List<Integer> result){

		if(root == null) return ;

		Stack<TreeNode> stack = new Stack();
		TreeNode cur;

		stack.push(root);
		while(!stack.isEmpty()){
			cur = stack.pop();
			result.add(cur.val);
			if(cur.right != null) stack.push(cur.right);
			if(cur.left != null) stack.push(cur.left);

		}
	}
}