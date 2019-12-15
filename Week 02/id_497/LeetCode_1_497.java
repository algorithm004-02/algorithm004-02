class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null && i != map.get(target - nums[i])) {
                ints[0] = i;
                ints[1] = map.get(target - nums[i]);
            }
        }
        return ints;
    }
}