import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

//TODO: 最佳答案还没有理解
class Solution {
    List<List<Integer>> treeNodeList = new ArrayList();
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> runDeque = new ArrayDeque();
        Deque<Node> waitDeque = new ArrayDeque();
        if (root != null) {
            runDeque.addLast(root);
            List<Integer> tempList = new ArrayList();
            tempList.add(root.val);
            treeNodeList.add(tempList);
        }

        while (runDeque.size() != 0 || waitDeque.size() != 0) {
            if (runDeque.size() == 0) {
                List<Integer> tempList = new ArrayList();
                while (waitDeque.size() != 0) {
                    Node node = waitDeque.pollFirst();
                    tempList.add(node.val);
                    runDeque.addLast(node);
                }
                if (tempList.size() != 0) {
                    treeNodeList.add(tempList);
                }
            }

            Node node = runDeque.pollFirst();

            if (node.children != null && node.children.size() != 0) {
                for (int i = 0; i < node.children.size(); i++) {
                    waitDeque.addLast(node.children.get(i));
                }
            }
        }

        return treeNodeList;
    }

    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList();
        nodeList.add(new Node(5,null));
        nodeList.add(new Node(6,null));

        List<Node> nodeList1 = new ArrayList();
        nodeList1.add(new Node(3,nodeList));
        nodeList1.add(new Node(2,null));
        nodeList1.add(new Node(4,null));


        Node node = new Node(1,nodeList1);
        System.out.println(new Solution().levelOrder(node));
    }
}
