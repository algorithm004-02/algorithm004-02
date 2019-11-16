
//for each num in nums , check (target - num) exists in nums
//解法1：check的过程，可以通过遍历逐个元素解决
//解法2：check的过程，用hashMap解决, 只要put了每个num，两次hashMap，
//
class Solution {

    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
               if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
               }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
    }

}