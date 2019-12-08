import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {
    List<Integer> treeNodeList = new ArrayList();
    public List<Integer> postorder(Node root) {
        if(root != null){
            for( int i = 0; i < ((root.children != null ) ? root.children.size() : 0); i++){
                postorder(root.children.get(i));
            }
            treeNodeList.add(root.val);
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

        List resultNodes = new Solution().postorder(node);
        System.out.println(resultNodes);
    }
}
