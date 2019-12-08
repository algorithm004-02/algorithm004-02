// https://leetcode-cn.com/problems/two-sum/description/
// two sum用hash table
// 两次循环
//  第一次循环，将所有数装入hash表<value, index>
//  第二次循环，检查complement存在于hash table吗
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i]) && hash.get(target - nums[i]) != i) {
                return new int[]{i, hash.get(target - nums[i])};
            }
        }
        throw new RuntimeException();
    }
}

// 只循环一次
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
            if (hash.containsKey(target - nums[i]) && hash.get(target - nums[i]) != i) {
                return new int[]{hash.get(target - nums[i]), i};
            }
        }
        throw new RuntimeException();
    }
}