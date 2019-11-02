package com.tulane.mine;

import com.tulane.base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给定一个 N 叉树，返回其节点值的前序遍历。

 例如，给定一个 3叉树 :

 返回其前序遍历: [1,3,5,6,2,4]。

 说明: 递归法很简单，你可以使用迭代法完成此题吗?

 */
public class Preorder {

    /**
     * 第一种 递归法
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        recursion(root, list);
        return list;
    }

    private void recursion(Node root, List<Integer> list){
        list.add(root.val);
        List<Node> nodes = root.children;
        if(nodes != null && nodes.size() > 0) for (Node node : nodes) {
            recursion(node, list);
        }
    }
}
