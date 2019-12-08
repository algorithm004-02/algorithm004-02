package src.main.java.com.fans.algorithm00402.week2.homework;

import java.awt.image.renderable.RenderableImage;
import java.util.HashMap;

/**
 * 【二叉树的最近公共祖先】
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class LeetCode_236_232 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 1. 递归  O(N*logN) O(N)   执行时间1329ms
     *  - 遍历每一颗子树，判断节点p和节点q是否在这颗子树中。
     *  - 如果在，就继续递归， 直到找不到p和q都在的子树
     *  - 返回最后一个找到的子树
     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // terminator
//        if (root == null) return null;
//
//        // process & drill down
//        TreeNode left = null;
//        TreeNode right = null;
//        if (hepler(root.left, p) && hepler(root.left, q)) {
//            // 在左子树中
//            left = lowestCommonAncestor(root.left, p, q);
//        } else if (hepler(root.right, p) && hepler(root.right, q)) {
//            //在右子树中
//            right = lowestCommonAncestor(root.right, p ,q);
//        }
//
//        if (left != null) return left;
//        if (right != null) return right;
//        return root;
//    }
//
//    private boolean hepler(TreeNode node ,TreeNode searchNode) {
//        if (node == null) return false;
//        if (node.val == searchNode.val) return true;
//        return hepler(node.left, searchNode) || hepler(node.right, searchNode);
//    }

    /**
     * 2. 优化递归 O(N) O(N)  执行时间19ms
     *  - 上面的递归是从上往下找， 其实中间有很多子树都是重复遍历了多次
     *  - 优化策略加入缓存， 用Node存是否存在searchNode
     */
//    private HashMap<Integer, Boolean> cachep = new HashMap<>();
//    private HashMap<Integer, Boolean> cacheq = new HashMap<>();
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // terminator
//        if (root == null) return null;
//
//        // process & drill down
//        TreeNode left = null;
//        TreeNode right = null;
//        if (hepler(root.left, p, cachep) && hepler(root.left, q, cacheq)) {
//            // 在左子树中
//            left = lowestCommonAncestor(root.left, p, q);
//        } else if (hepler(root.right, p, cachep) && hepler(root.right, q, cacheq)) {
//            //在右子树中
//            right = lowestCommonAncestor(root.right, p, q);
//        }
//
//        if (left != null) return left;
//        if (right != null) return right;
//        return root;
//    }
//
//    private boolean hepler(TreeNode node, TreeNode searchNode, HashMap<Integer, Boolean> cache) {
//        if (node == null) return false;
//        if (node.val == searchNode.val) return true;
//        Integer key = node.val;
//        if (cache.get(key) == null) cache.put(key, hepler(node.left, searchNode, cache) || hepler(node.right, searchNode, cache));
//        return cache.get(key);
//    }

    /**
     * 3. 回溯法 O(N) O(N)  执行时间9ms
     *  - 上面的方法都是有两个递归体
     *  - 用回溯法，一遍即可。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftRoot = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRoot = lowestCommonAncestor(root.right, p, q);
        return (leftRoot != null && rightRoot != null) ? root : (leftRoot != null ? leftRoot : rightRoot);
    }
}
