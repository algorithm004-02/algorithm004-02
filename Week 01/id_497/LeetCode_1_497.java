class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        a:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                    break a;
                }
            }
        }
        return ints;
    }
}