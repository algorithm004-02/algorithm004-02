class Solution {
    public int jump(int[] nums) {
        int pos = 0;
        int maxPos = 0;
        int bounder = 0;
        int count = 0;
        while(pos < nums.length - 1) {
            maxPos = Math.max(maxPos, nums[pos] + pos);
            if (pos == bounder) {
                bounder = maxPos;
                count++;
            }
            pos++;
        }
        return count;
    }
}