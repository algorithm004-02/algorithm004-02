/**
 * 跳跃游戏
 * Created by yangwenwei on 2019/10/29.
 */
public class LeetCode_55_597 {
    class Solution {

        //贪心算法
        public boolean canJump(int[] nums) {
            int endReachable = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] + i >= endReachable) endReachable = i;
            }
            return endReachable == 0;
        }
    }
}
