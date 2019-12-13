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
    
    List<Integer> res = new ArrayList<Integer>();
    
    public List<Integer> postorder(Node root) {
        
        
        
        if (root == null ){
            return res;
        }
        
        
        
        for (int i = 0; i < root.children.size(); i++) {
            
             postorder(root.children.get(i));//Be careful, if u define res outsize the block, should not res.addAll, this will save time and memory.
            
        }
        
        res.add(root.val);
        
       
            
        return res;
        
    }
}