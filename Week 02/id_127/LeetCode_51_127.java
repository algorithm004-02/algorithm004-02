class Solution {
	public List<List<String>> solveNQueens(int n) {
	List<Integer> nums = new ArrayList<Integer>();
	Map<Integer,String> mapList = new HashMap<Integer,String>();
	for(int i = 0; i < n; i++) {
		nums.add(i);
		String value = "";
		for(int j = 0; j < n; j++) {
			if(j == i) {
				value += "Q";
			} else {
				value += ".";
			}
		}
		mapList.put(i, value);
	}
	List<Integer> list = new ArrayList<Integer>();
	List<List<String>> queenList = new ArrayList<List<String>>();
	getQueens(n, list, queenList, mapList);
	return queenList;
    
}
private void getQueens(int n,List<Integer> list,List<List<String>> queenList,Map<Integer,String> mapList) {
	Integer dealLine = list.size();
	if(list.size() == n) {
		List<String> strList = new ArrayList<String>();
		for(Integer index : list) {
			strList.add(mapList.get(index));
		}
		queenList.add(strList);
		return;
	}
	List<Integer> unuse = new ArrayList<Integer>();
	for(int i = 0; i < list.size(); i++) {
		Integer cur = list.get(i);
		if(cur-(dealLine-i) >=0) {
			unuse.add(cur-(dealLine-i));
		}
		unuse.add(cur);
		if(cur+(dealLine-i) < n) {
			unuse.add(cur+(dealLine-i));
		}
	}
	for(int i = 0; i < n; i++) {
		if(!unuse.contains(i)) {
			list.add(i);
			getQueens(n,list,queenList,mapList);
			list.remove(list.size()-1);
		}
	}
}



}