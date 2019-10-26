import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (46.76%)
 * Likes:    6552
 * Dislikes: 0
 * Total Accepted:    607.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
        for (int i = 0;i < nums.length;i++) {
            sumMap.put(nums[i],i);
        }

        int[] result = null;
        for (int i = 0;i<nums.length;i++) {

            int num = target - nums[i];
            if(sumMap.containsKey(num))
            {
                result = new int[2];
                result[0] = i;
                result[1] = sumMap.get(num);
                return result;
            }            
        }
        return result;
    }
}
// @lc code=end

