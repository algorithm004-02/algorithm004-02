/*
    102. 二叉树的层次遍历
    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */

// 解法 1: 递归
// 思路: 比较当前层次的 level, 每个 level 对应一个列表, 将相同 level 的值放入同一个列表.
// public class Solution
// {
//     private readonly IList<IList<int>> result = new List<IList<int>>();

//     public IList<IList<int>> LevelOrder(TreeNode root)
//     {
//         if (root == null) return result;

//         Helper(root, 0);

//         return result;
//     }

//     private void Helper(TreeNode node, int level = 0)
//     {
//         if (result.Count == level)
//             result.Add(new List<int>());

//         result[level].Add(node.val);

//         if (node.left != null)
//             Helper(node.left, level + 1);

//         if (node.right != null)
//             Helper(node.right, level + 1);
//     }
// }


// 解法 2: 迭代
// 思路: 使用队列保存当前层级的所有结点, 然后将相同层级的结点存入列表
public class Solution2
{
    public IList<IList<int>> LevelOrder(TreeNode root)
    {
        var result = new List<IList<int>>();

        if (root == null) return result;

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        int level = 0;
        while (queue.Any())
        {
            result.Add(new List<int>());

            int levelLength = queue.Count;

            for (int i = 0; i < levelLength; i++)
            {
                TreeNode node = queue.Dequeue();

                // 入队当前层级的结点
                result[level].Add(node.val);

                // 将当前层级的结点的左右孩子入队
                if (node.left != null) queue.Enqueue(node.left);
                if (node.right != null) queue.Enqueue(node.right);
            }

            // 到下一个层级
            level++;
        }

        return result;
    }
}