package datastruct.dfsAndbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 *
 * 您需要在二叉树的每一行中找到最大的值。

 示例：

 输入:

 1
 / \
 3   2
 / \   \
 5   3   9

 输出: [1, 3, 9]

 *
 */
public class FindLargestValueInEachTreeRow {


    public static void main(String[] args) {

    }


    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int cnt = 1;
        int maxValue = Integer.MIN_VALUE;

        while (nodeList.size()>0 && cnt-- > 0) {
            TreeNode node = nodeList.removeFirst();
            maxValue = maxValue > node.val ? maxValue : node.val;
            if (node.left != null)
                nodeList.add(node.left);
            if (node.right != null)
                nodeList.add(node.right);

            if (cnt == 0) {
                list.add(maxValue);
                maxValue = Integer.MIN_VALUE;
                cnt = nodeList.size();
            }
        }
        return list;
    }
}
