package Week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);

                if(node.right != null){
                    stack.push(node.right);
                }

                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
        return list;
    }
}
