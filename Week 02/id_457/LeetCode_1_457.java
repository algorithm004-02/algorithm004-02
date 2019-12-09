class Solution {
    
    /** 
		一遍哈希表
		时间复杂度：O(n)，只遍历了包含有n个元素的列表一次。
					在表中进行的每次查找只花费 O(1) 的时间。
		空间复杂度：O(n)，所需的额外空间取决于哈希表中存储的元素数量，
					该表最多需要存储 n 个元素。
	*/
    public int[] twoSum(int[] nums, int target) {
        int[] resultNumsIndexs = new int[2];
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                int diff = target-nums[i];
                if (map.containsKey(diff)) {
                    resultNumsIndexs[0] = map.get(diff);
                    resultNumsIndexs[1] = i;
                    
                }
                map.put(nums[i], i);
            }
             return resultNumsIndexs;
    }
    
}