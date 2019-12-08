class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[length / 2];

    }
}