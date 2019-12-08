package id_617;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历 
 */
public class BinaryTree_Preorder {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }
    
    public void preorder(TreeNode root, List<Integer> res) {
        // 先判断root是否为空
        if (root != null){
            // 根节点
            res.add(root.val);
            // 左节点
            preorder(root.left, res);
            // 右节点
            preorder(root.right, res);
        }
    }
}
