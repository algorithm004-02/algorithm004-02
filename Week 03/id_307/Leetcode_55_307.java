class Solution {
    public boolean canJump(int[] nums) {
        int steps = nums[0];
        int pos = 0;
        while (steps > 0 && pos < nums.length - 1) {
            pos++;
            steps--;
            steps = Math.max(steps, nums[pos]);
        }
        return pos == nums.length - 1;
    }
}