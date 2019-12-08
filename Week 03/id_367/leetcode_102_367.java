/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*二叉树的层次遍历*/
/*遍历二叉树的层次，使用递归实现*/
class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();//list允许元素有重复值，定义一个二维数组
    public void helper(TreeNode node,int level){
        if(levels.size()==level)	//到达树的最大深度、给树添加null节点                             
            levels.add(new ArrayList<Integer>());
        levels.get(level).add(node.val);//在树的相应层次添加节点
        if( node.left!=null )
            helper(node.left,level+1);
        if( node.right!=null )
            helper(node.right,level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if( root == null ) return levels;
        helper( root,0 );
        return levels;
    }
}
/*遍历二叉树的层次，使用队列实现*/
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();//声明一个二维数组
    if (root == null) return levels;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();//声明TreeNode队列
    queue.add(root);//在队列中添加root结点
    int level = 0;//树的深度
    while ( !queue.isEmpty() ) {
      // start the current level
      levels.add(new ArrayList<Integer>());

      // number of elements in the current level
      int level_length = queue.size();
      for(int i = 0; i < level_length; ++i) {
        TreeNode node = queue.remove();//将队列中的结点赋给node

        // fulfill the current level
        levels.get(level).add(node.val);//

        // add child nodes of the current level
        // in the queue for the next level
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      // go to next level
      level++;
    }
    return levels;
  }
}

