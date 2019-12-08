package datastruct.dfsAndbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  102. 二叉树的层次遍历
 *      给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
    例如:
        给定二叉树: [3,9,20,null,null,15,7],
 *
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    List<List<Integer>> levels = new ArrayList<>();

    /**
     * dfs做法
     *
     * 复杂度分析

        时间复杂度：O(N)，因为每个节点恰好会被运算一次。
        空间复杂度：O(N)，保存输出结果的数组包含 N 个节点的值。
     *
     */
    public void helper (TreeNode node,int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<>());

        // fulfil ther current level
        // 把节点添加到当前层的集合中
        levels.get(level).add(node.val);

        // process child nodes for the next level
        //处理当前节点的子节点再下一层中
        if (node.left != null)
            helper(node.left,level +1);
        if (node.right != null)
            helper(node.right,level + 1);
    }

    public List<List<Integer>> levelOrder (TreeNode root) {
        if (root == null) return levels;
        helper(root,0);
        return levels;
    }

    /**
     * BFS 做法
     * 方法 2：迭代
     *  算法

     上面的递归方法也可以写成迭代的形式。

     我们将树上顶点按照层次依次放入队列结构中，队列中元素满足 FIFO（先进先出）的原则。在 Java 中可以使用 Queue 接口中的 LinkedList实现。在 Python 中如果使用 Queue 结构，但因为它是为多线程之间安全交换而设计的，所以使用了锁，会导致性能不佳。因此在 Python 中可以使用 deque 的 append() 和 popleft() 函数来快速实现队列的功能。

     第 0 层只包含根节点 root ，算法实现如下：

     初始化队列只包含一个节点 root 和层次编号 0 ： level = 0。
     当队列非空的时候：
     在输出结果 levels 中插入一个空列表，开始当前层的算法。
     计算当前层有多少个元素：等于队列的长度。
     将这些元素从队列中弹出，并加入 levels 当前层的空列表中。
     将他们的孩子节点作为下一层压入队列中。
     进入下一层 level++。

     复杂度分析

     时间复杂度：O(N)O(N)，因为每个节点恰好会被运算一次。
     空间复杂度：O(N)O(N)，保存输出结果的数组包含 N 个节点的值。
     */

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            // 开始当前层操作
            levels.add(new ArrayList<>());

            // 遍历当前层的所有节点
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.remove();


                // 把节点添加到当前层
                levels.get(level).add(node.val);

                // 添加子节点到当前层
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // 进入下一层
            level ++;
        }
        return levels;
     }

}
