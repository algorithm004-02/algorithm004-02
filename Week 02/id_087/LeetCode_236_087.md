# 236. [二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

## 题目

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]

![image](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/binarytree.png)

==示例 1:==

```
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
```

==示例 2:==

```
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
```

==说明:==

* 所有节点的值都是唯一的。
* p、q 为不同节点且均存在于给定的二叉树中。

## 递归

> 判断当前结节、左边节点、右边节点是否存在 p 或 q，如果存在，返回 1。超过根、左、右中，大于等于两个满足条件，则这个节点是公共祖先。

```
class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isCommonAncestor(root, p, q);
        return result;
    }

    int isCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return 0;
        }
        // 左子树是否存在 p 或 q
        int isLeft = isCommonAncestor(node.left, p, q);
        // 右子树是否存在 p 或 q
        int isRight = isCommonAncestor(node.right, p, q);
        int isMid = (node == p || node == q) ? 1 : 0;
        if (isLeft + isRight + isMid >= 2) {
            result = node;
        }
        return ((isLeft + isRight + isMid) > 0) ? 1 : 0;
    }
}
```



