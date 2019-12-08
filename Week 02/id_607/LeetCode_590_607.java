class Solution {
//递归法
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        //深度优先遍历
        if (root == null) return list;
        for (int i = 0; i < root.children.size(); i++) {
            Node node = root.children.get(i);
            postorder(node);
        }
        list.add(root.val); 
        return list;
    }
    
}