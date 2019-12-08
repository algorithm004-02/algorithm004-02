public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList();
    helper(root, ans);
    return ans;

}
    
public void helper(TreeNode root, List<Integer> ans) {
    if (root != null) {
        if (root.left != null) {
            helper(root.left, ans);
        }
        ans.add(root.val);
        if (root.right != null) {
            helper(root.right, ans);
        }
    }
}

// preorder
public void helper(TreeNode root, List<Integer> ans) {
    if (root != null) {
        ans.add(root.val);
        if (root.left != null) {
            helper(root.left, ans);
        }
        if (root.right != null) {
            helper(root.right, ans);
        }
    }
}

// postorder
public void helper(TreeNode root, List<Integer> ans) {
    if (root != null) {
        if (root.left != null) {
            helper(root.left, ans);
        }
        if (root.right != null) {
            helper(root.right, ans);
        }
        ans.add(root.val);

    }
}

// N-ary tree postorder traversal
List<Integer> ans = new ArrayList();
public List<Integer> postorder(Node root) {
    if (root == null) {
        return ans;
    }
    for (Node chi: root.children) {
        postorder(chi);
    }
    ans.add(root.val);
    return ans;
}


// N-ary tree Preorder Traversal
List<Integer> ans = new ArrayList();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        for (Node chi: root.children) {
            preorder(chi);
        }
        return ans;
    }