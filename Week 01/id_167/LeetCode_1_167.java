class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 一层Map法
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            // 判断target - nums[i]的值是否在map中，如果存在则证明找到结果，输出下标
            int element = target - nums[i];
            if (map.containsKey(element)) {
                return new int[]{map.get(element), i};
            }
            // 如果不存在就将当前的值以及下标放入map中
            map.put(nums[i], i);
        }
        return null;
    }
}