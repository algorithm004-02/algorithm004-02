/*
    94. 二叉树的中序遍历
    给定一个二叉树，返回它的中序遍历。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class Solution
{

    // 解法 1: 递归
    // public IList<int> InorderTraversal(TreeNode root)
    // {
    //     IList<int> nodeList = new List<int>();
    //     Traversal(root, nodeList);

    //     return nodeList;
    // }

    // public void Traversal(TreeNode root, IList<int> nodeList)
    // {
    //     if (root != null)
    //     {
    //         if (root.left != null)
    //         {
    //             Traversal(root.left, nodeList);
    //         }

    //         nodeList.Add(root.val);

    //         if (root.right != null)
    //         {
    //             Traversal(root.right, nodeList);
    //         }
    //     }
    // }



    // 解法 2: 基于栈的遍历
    // 利用栈先进后出的特点, 先遍历所有结点的左子树, 直到末端,
    // 然后从末端开始, 将左子树结点依次出栈并添加到集合中, 同时继续遍历右子树
    // 以此类推, 当左右子树都遍历完后, 根节点(父结点)出栈并添加到
    public IList<int> InorderTraversal(TreeNode root)
    {
        IList<int> res = new List<int>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode curr = root;
        while (curr != null || stack.Any())
        {
            while (curr != null)
            {
                stack.Push(curr);
                curr = curr.left;
            }

            TreeNode node = stack.Pop();
            res.Add(node.val);
            curr = node.right;
        }
        return res;
    }
}
