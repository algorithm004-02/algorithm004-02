package id_617;
/*
 * 前序（Pre-Order）：根 - 左 - 右
 * 中序（In-Order）：左 - 根 - 右
 * 后序（Post-Order）：左 - 右 - 根
 * 
 * def preorder(self, root):
 * 	if root:
 * 		self.traverse_path.append(root.val)
 * 		self.preorder(root.left)
 * 		self.preorder(root.right)
 * 
 * def inorder(self, root):
 * 	if root:
 * 		self.inorder(root.left)
 * 		self.traverse_path.append(root.val)
 * 		self.inorder(root.right)
 * 
 * def postorder(self, root):
 * 	if root:
 * 		self.postorder(root.left)
 * 		self.postorder(root.right)
 * 		self.traverse_path.append(root.val)
 */

import java.util.ArrayList;
import java.util.List;
/**
 * 创建树类
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

/**
 * 中序遍历二叉树：左->中->右
 */
public class BinaryTree_Inorder {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    
    public void inorder (TreeNode root, List<Integer> res) {
    	// 先判定节点不可以为空    	
    	if(root != null) {
    		// 左节点    	
    		if(root.left != null) {
    			inorder(root.left, res);
    		}
    		// 节点处理    		
            res.add(root.val);
            // 右节点
            if(root.right != null) {
                inorder(root.right, res);
            }  
        }
    }
}
