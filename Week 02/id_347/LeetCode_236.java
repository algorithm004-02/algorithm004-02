class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean containP, containQ;
    	
    	if(root.val == p.val || root.val == q.val)
        	return root;
        if(root.right == null)
        	return lowestCommonAncestor(root.left, p, q);
        if(root.left == null)
        	return lowestCommonAncestor(root.right, p, q);
        containP = contains(root.left, p);
        containQ = contains(root.left, q);
        if(containP && containQ)
        	return lowestCommonAncestor(root.left, p, q);
        if(!containP && !containQ)
        	return lowestCommonAncestor(root.right, p, q);
        return root;
    }

	private boolean contains(TreeNode root, TreeNode target) {
		if(root.val == target.val)
			return true;
		if(root.left == null && root.right == null)
			return false;
		if(root.right == null)
			return contains(root.left, target);
		if(root.left == null)
			return contains(root.right, target);
		return contains(root.left, target) || contains(root.right, target);
	}
}
