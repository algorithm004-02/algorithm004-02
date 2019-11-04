/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
    102. 二叉树的层次遍历
    深度优先（递归）
    时间复杂度：O(N)，因为每个节点恰好会被运算一次。
    空间复杂度：O(N)，保存输出结果的数组包含 N 个节点的值。
*/
// class Solution {
//     List<List<Integer>> levels = new ArrayList<List<Integer>>(); 
    
//     public void helper(TreeNode node, int level) {
//         if (levels.size() == level) {
//             levels.add(new ArrayList<Integer>());
//         }
        
//         levels.get(level).add(node.val);
        
//         if (node.left != null) {
//             helper(node.left, level+1);
//         }
        
//         if (node.right != null) {
//             helper(node.right, level+1);
//         }
//     }
    
//     public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) {
//            return levels;
//        } 
//         helper(root, 0);
//         return levels;
//     }
// }

/**
    102. 二叉树的层次遍历
    广度优先 （队列）
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>());
            
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //进入下一层
            level++;
        }
         return levels;
    }
}

