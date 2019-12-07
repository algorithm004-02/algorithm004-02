/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (46.84%)
 * Likes:    6606
 * Dislikes: 0
 * Total Accepted:    623.3K
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
        // return planA(nums,target);
        return planB(nums,target);
    }

    public int[] planA(int[] nums, int target) {
        int[] data=new int[2];
        for(int p1=0;p1<nums.length;p1++){
            for(int p2=p1+1;p2<nums.length;p2++){
                if(nums[p1]+nums[p2]==target){
                    data[0]=p1;
                    data[1]=p2;
                    return data;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] planB(int[] nums, int target) {
        int[] data=new int[2];
        //将数组值作为key，索引作为value存入map中
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                data[0]=map.get(complement);
                data[1]=i;
                return data;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
// @lc code=end

