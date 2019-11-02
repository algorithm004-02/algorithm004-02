/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        
        //User preorder traversal tree
        buildString(root, sb);
        
        
        return sb.toString();
    }
    
    public void buildString(TreeNode node, StringBuilder s) {
        
        
        if (node == null) {
             s.append("X").append(",");
            return;
        }
        
        s.append(node.val).append(",");
            
        
            buildString(node.left, s);//don't check null here
        
        
        
            buildString(node.right, s);//dont' check null here
        
            
        
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Deque<String> queue = new LinkedList();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue);
        
    }
    
    public TreeNode buildTree(Deque<String> nodes){
        
        String val = nodes.remove();
        
        if ( val.equals("X")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(val));
        
        node.left = buildTree(nodes);
            
        node.right = buildTree(nodes);
        
        return node;
        
        
        
        
        
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));