/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (74.95%)
 * Likes:    368
 * Dislikes: 0
 * Total Accepted:    42.1K
 * Total Submissions: 56.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(nums,ans,new ArrayList<Integer>(),0);
        return ans;
    }

    public void dfs(int[] nums,List<List<Integer>> ans,List<Integer> list,int index) {
           if(index==nums.length){
               ans.add(new ArrayList<Integer>(list));
               return;
           } 
           dfs(nums,ans,list,index+1);
           list.add(nums[index]);
           dfs(nums,ans,list,index+1);
           list.remove(list.size()-1);
    }
}
// @lc code=end

