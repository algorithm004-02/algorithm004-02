/**
 * 分发饼干||
 */
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        return each(nums,0,0);
    }

    private int each(int[] nums, int index,int currentLevel) {
        int max = index + nums[index];
        if (max >= nums.length - 1) {
            return currentLevel + 1;
        }
        int maxtarget = Integer.MIN_VALUE;
        int maxTargetIndex = 0;
        for (int i = index; i <= max; i++) {
            int depth = nums[i] + i;
            if (depth >= maxtarget) {
                maxtarget = depth;
                maxTargetIndex = i;
            }
        }
        return each(nums,maxTargetIndex,currentLevel+1);
    }
}