package datastruct.recur;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最大深度
 * 给定一个二叉树，找出其最小深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 */
public class MinimumDepthOfBinaryTree {


    /**
     * 方法一、递归，使用DFS方式搜索最大深度
     * 时间复杂度：
     *  O(N)
     *  空间复杂度：
     *  最差O(N),最好O(log(N))
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null) && (root.right == null)) return 1;

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) min_depth = Math.min(minDepth(root.left), min_depth);
        if (root.right != null) min_depth = Math.min(minDepth(root.right), min_depth);
        return min_depth + 1;
    }


    /**
     * 方法二：深度优先搜索迭代
     我们可以利用栈将上述解法中的递归变成迭代。
     想法是对于每个节点，按照深度优先搜索的策略访问，同时在访问到叶子节点时更新最小深度。
     我们从一个包含根节点的栈开始，当前深度为 1 。
     然后开始迭代：弹出当前栈顶元素，将它的孩子节点压入栈中。当遇到叶子节点时更新最小深度。
        时间复杂度：
     *      O(N)
     *  空间复杂度：
     *      O(N)
     */

    public int minDepth1(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return min_depth;
    }

    /**
     * 方法三：宽度优先搜索迭代
        深度优先搜索方法的缺陷是所有节点都必须访问到，以保证能够找到最小深度。因此复杂度是 O(N)。
        一个优化的方法是利用宽度优先搜索，我们按照树的层次去迭代，第一个访问到的叶子就是最小深度的节点，
        这样就不要遍历所有的节点了。

     时间复杂度：最坏情况下，这是一棵平衡树，我们需要按照树的层次一层一层的访问完所有节点，除去最后一层的节点。
     这样访问了 N/2 个节点，因此复杂度是 O(N)
     空间复杂度：和时间复杂度相同，也是 O(N)。
     */
    public int minDepth3(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        else {
            stack.add(new Pair(root, 1));
        }

        int current_depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                break;
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return current_depth;
    }


}
