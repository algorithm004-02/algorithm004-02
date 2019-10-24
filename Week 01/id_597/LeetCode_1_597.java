//两数之和
class Solution {
    //暴力解法
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //将减法移到此处能减少多次重复的减法操作
            int sub = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sub == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //将数组都插入哈希表中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub) && map.get(sub) != i) {
                return new int[]{i, map.get(sub)};
            }
        }
        return new int[0];
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}