class Solution {
    // 方法1：暴力解法
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
                }
            }
        }
        return new int[2];
    }
    
    // 方法2：两遍哈希表，利用空间换时间的思想降低时间复杂度
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                return new int[] {i, map.get(nums[i])};
            }
        }
        return new int[2];
    } 
    
    // 方法3：一遍哈希表，由于在遍历数组的过程中，可以回过头来查找哈希表中是否存储了目标元素的值，
    // 因此，没有必要遍历完整的数组将目标元素的值存储到哈希表中，可以边遍历边存储。
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                return new int[] {map.get(component), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    } 
}
