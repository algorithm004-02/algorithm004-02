package datastruct.tree;

import java.util.*;

/**
 * N叉树后序遍历
 */
public class NAryTreeLevelorderTraversal {


//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val,List<Node> _children) {
//        val = _val;
//        children = _children;
//    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;

        List<Node> list1 = new ArrayList<>();
        Node root1 = new Node();
        root1.val = 3;

        List<Node> list2 = new ArrayList<>();
        Node root11 = new Node();
        root11.val = 5;
        Node root12 = new Node();
        root12.val = 6;
        list2.add(root11);
        list2.add(root12);
        root1.children = list2;


        Node root2 = new Node();
        root2.val = 2;
        Node root3 = new Node();
        root3.val = 4;

        list1.add(root1);
        list1.add(root2);
        list1.add(root3);

        root.children = list1;

        List<List<Integer>> res = new NAryTreeLevelorderTraversal().levelOrder2(root);
        res.forEach(x->{
            x.forEach(y->{
                System.out.print(y+",");
            });
            System.out.println();
        });
    }


    /**
     * 方法1
     *  时间复杂度为O(n)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root,res,0);
        return res;
    }


    public void helper(Node root,List<List<Integer>> res,int level) {
        if(root!=null) {
            List<Integer> list = res.size() > level ? res.get(level):new ArrayList<>();
            list.add(root.val);

            if(list.size()==1)
                res.add(list);
            else
                res.set(level,list);
            level++;
            if(root.children!=null){
                for(Node node:root.children) {
                    helper(node,res,level);
                }
            }
        }
    }


    /**
     * 方法2
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null) return ret;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }
}
