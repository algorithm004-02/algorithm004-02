package datastruct.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历 中序(In-order):左-根-右
 */
public class BinaryTreeInorderTraversal {


    public static void main(String[] args) {
        //[1,null,2,3]

        TreeNode root = new TreeNode(1);
        TreeNode rightNode = new TreeNode(2);
        rightNode.left = new TreeNode(3);
        root.right = rightNode;

        List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal2(root);
        list.forEach(x->System.out.print(x+","));
        System.out.println();
    }


    /**
     *  方法一：递归
        第一种解决方法是使用递归。这是经典的方法，直截了当。
        我们可以定义一个辅助函数来实现递归。

        复杂度分析
        时间复杂度：O(n)。递归函数 T(n) = 2 T(n/2)+1。
        空间复杂度：最坏情况下需要空间O(n)，平均情况为O(\log n)。

     */
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode root,List<Integer> res) {
        if(root != null)
        {
            if (root.left != null) {
                helper(root.left,res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right,res);
            }
        }

    }

    /**
     *
     * 方法二：基于栈的遍历
     * 本方法的策略与上衣方法很相似，区别是使用了栈。
     *  时间复杂度：O(n)。
     *  空间复杂度：O(n)。
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * 方法三：莫里斯遍历
        本方法中，我们使用一种新的数据结构：线索二叉树。方法如下：
             Step 1: 将当前节点current初始化为根节点
             Step 2: While current不为空，
         若current没有左子节点
             a. 将current添加到输出
             b. 进入右子树，亦即, current = current.right
         否则
             a. 在current的左子树中，令current成为最右侧节点的右子节点
             b. 进入左子树，亦即，current = current.left
     *
     *
     * 时间复杂度：O(n)。
     * 想要证明时间复杂度是O(n)，
     * 最大的问题是找到每个节点的前驱节点的时间复杂度。
     * 乍一想，找到每个节点的前驱节点的时间复杂度应该是 O(nlogn)，
     *  因为找到一个节点的前驱节点和树的高度有关。
        但事实上，找到所有节点的前驱节点只需要O(n)时间。
     一棵 n个节点的二叉树只有 n-1 条边，每条边只可能使用2次，
     一次是定位节点，一次是找前驱节点。
        故复杂度为 O(n)。
        空间复杂度：O(n)。使用了长度为 n 的数组。
     *
     */
    public List < Integer > inorderTraversal3(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }


    /**
     *
     * 4、颜色标记法
     *  其核心思想如下：
     使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     如果遇到的节点为灰色，则将节点的值输出。
     */
    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }


    public List<Integer> inorderTraversal4(TreeNode root) {

        //节点为null时候返回新list
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();

        //创建一个ColorNode类型的栈。
        Stack<ColorNode> stack = new Stack<>();
        //把当前root节点加入到栈中
        stack.push(new ColorNode(root,"white"));

        //判断栈为空时候
        while(!stack.empty()){

            //栈的节点弹出
            ColorNode cn = stack.pop();

            //判断当前节点是否已经遍历过，如果是 white 则表示未遍历
            if(cn.color.equals("white")){

                //当前节点的右子节点不为空时候，加入到栈中，并设为未读
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                //把当前节点添加到栈中，并设为已读
                stack.push(new ColorNode(cn.node,"gray"));
                //当前节点的左子节点不为空时候，加入到栈中，并设为未读
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
            }else{
                //节点为已读时候添加到result结果的list中
                res.add(cn.node.val);
            }
        }

        return res;
    }

}
