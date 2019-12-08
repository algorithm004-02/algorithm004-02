
Thinking:
1/使用递归，标记递归中的深度，相同深度的加入到一个list中。深度优先搜索的灵活应用。
2/维护一个队列，首先头结点入队，其次再将队列中的所有节点出队，将其所有子节点入队，直到所有节点出队完成，队列为空，其出队列的顺序就是广度优先遍历。
Code:
java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        this.recursion(root, 0, list);
        return list;
    }
    //递归  广度优先遍历
    private void recursion(Node root, int depth, List<List<Integer>> list) {
        if(root == null) {//1.terminator
            return;
        }
        //初始化 条件 判断是否深度到了新的一层
        if (list.size() - 1 < depth) {
            list.add(new ArrayList<>());
        }
        list.get(depth++).add(root.val);// process logic in current level

        for (Node child : root.children) {//3、drill down
            recursion(child, depth, list);
        }
    }
}


思想2
public List<List<Integer>> levelOrder(Node root) {
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

