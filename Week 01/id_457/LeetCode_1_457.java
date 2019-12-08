class Solution {
    
    // 一遍哈希表
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
	
    
    public int[] twoSum(int[] nums, int target) {
        int[] resultNumsIndexs = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i<nums.length; i++) {
            int diff = target-nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                resultNumsIndexs[0] = i;
                resultNumsIndexs[1] = map.get(diff);
            }
        }
         return resultNumsIndexs;
    }
	
	// 嵌套双循环（暴力求解）
    // public int[] twoSum(int[] nums, int target) {
    //     int[] resultNumsIndexs = new int[2];
    //     for (int i = 0; i<nums.length; i++) {
    //         for (int j = i+1; j<nums.length; j++) {
    //             if (nums[i]+nums[j]==target) {
    //                 resultNumsIndexs[0] = i;
    //                 resultNumsIndexs[1] = j;
    //             }
    //         }
    //     }
    //      return resultNumsIndexs;
    // }
    
}