//Given an array of non-negative integers, you are initially positioned at the first index of the array. 
//
// Each element in the array represents your maximum jump length at that position. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// Example: 
//
// 
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
//
// Note: 
//
// You can assume that you can always reach the last index. 
// Related Topics Array Greedy


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        //统计之前节点开始能到达的最远位置，找到下次跳跃的最远位置，
        // 在到达最远位置的时候必须进行一次跳跃，并且修改能够到达的最远位置

        for (int i = 0; i < nums.length - 1; i++) {
            //修改下次能到到达的最远位置
            curFarthest = Math.max(curFarthest, i + nums[i]);
            //在到达此次最远位置的时候必须进行一次跳跃，并且修改下次的最远到达位置
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
