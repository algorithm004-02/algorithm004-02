class Solution {
    
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(null != root) {
			getdepthNode(root,0,list);
		}
		return list;
        
    }
	private void getdepthNode(Node node,int depth,List<List<Integer>> list) {
		if(depth + 1 > list.size()) {
			list.add(new ArrayList<Integer>());
		} 
		list.get(depth).add(node.val);
		for(Node n:node.children) {
			if(null != n) {
				getdepthNode(n,depth+1,list);
			}
		}
	}

}