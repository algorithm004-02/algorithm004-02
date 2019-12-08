package datastruct.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * N叉树后序遍历
 */
public class NAryTreePreorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    /**
     * 方法1
     *  时间复杂度为O(n)
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(Node root,List<Integer> res) {
        if(root!=null) {
            res.add(root.val);
            if(root.children!=null){
                for (int i = 0;i<root.children.size();i++)helper(root.children.get(i),res);
//                root.children.forEach(childrenNode->helper(childrenNode,res));
            }
        }
    }

    /**
     * 方法2
     * 时间复杂度为O(n)
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder2(Node root) {
        if (root == null)
            return list;

        list.add(root.val);
        for(Node node: root.children)
            preorder2(node);


        return list;
    }

    /**
     * 方法3 ,迭代方法
     *  时间复杂度为O(nlogn)
     */
    public List<Integer> preorder3(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        //创建栈
        Stack<Node> stack = new Stack<>();
        //添加节点
        stack.add(root);

        //迭代，判断当前栈是否为空
        while(!stack.isEmpty()) {

            root = stack.pop();
            list.add(root.val);

            //遍历子节点，把子节点放到堆中，然后继续后续迭代
            for(Node node: root.children)
                stack.add(node);
        }
        //因为是用栈来处理，所以实际顺序是跟解答想法，需要重新排序
        Collections.reverse(list);
        return list;
    }
}
