class LeetCode_590_487{
    /***
     *
     * 590题目
     *
     * 给定一个二叉树，返回它的前序 遍历。
     *
     *class Node {
     *     public int val;
     *     public List<Node> children;
     *
     *     public Node() {}
     *
     *     public Node(int _val,List<Node> _children) {
     *         val = _val;
     *         children = _children;
     *     }
     * };
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> integers = new ArrayList<>();
        helperH(root, integers);
        return integers;
    }

    public void helperH(Node root, List<Integer> ans) {
        //1结束终止条件
        if (root == null) {
            return;
        }

        // 2.处理当前层逻辑    3。去到下一层
        for (Node node : root.children) {
            helperH(node, ans);
        }
        ans.add(root.val);

        //4释放当前层数据
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}