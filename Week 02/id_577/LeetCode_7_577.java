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

class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        
        if (root == null) {
            return  res;
        }
        
        helper(root,0, res);
        
        return res;
            
        
    }
    
    public void helper(Node root, int depth, List<List<Integer>> res){
        
        
        //check boundary
        if (root == null) {
            return;
        }
        
        
        
        //check depth is sample as res size
        
        if ( (depth + 1) > res.size()) {
            res.add(new ArrayList<>());
        }
        
        res.get(depth).add(root.val);//dont' forget this
        
        
        
        // Recurrsion over childeren
        
        for (Node node : root.children) {
            helper(node, depth+1, res);
        }
        
        
        
    }
}
*/


//user queue as iteration over 

class Solution {
    
 public List<List<Integer>> levelOrder(Node root) {
     
     List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) {
            return  res;
        }
        
       Queue<Node> queue =  new LinkedList<>();
     
       queue.add(root);
     
       while(!queue.isEmpty()) {
           int count = queue.size();
           List<Integer> list = new ArrayList<>();
           while (count-->0 ) {
               Node curr = queue.poll();
               
               list.add(curr.val);
                   
               for(Node node : curr.children) {
                   
                   if (node != null) {
                       
                       queue.add(node);
                       
                   }
                   
               }
             
               
           }
           res.add(list);
       }
        
     return res;       
        
 }
    
}

public List<List<Integer>> levelOrder(Node root) {
    
    List<List<Integer>> res = new ArrayList()<>;
    if (root == null) {
        return 
    }
    
    Queue<Node> queue = new LinkedList<>();
    
    while (!queue.isEmpty()) {
        int count = queue.size();
        
        List<Integer> list =  new ArrayList<>();
        while(count-- >0) {
            Node curr = queue.poll();
            
            list.add(curr.val);
            
            for(Node node : curr.children) {
                if (node != null) {
                    queue.add(node);
                }
            }
        
            
            
        
        }
        
        res.add(list)
    }
    
    return res;
}