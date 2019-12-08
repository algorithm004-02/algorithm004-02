//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
// Related Topics Array Dynamic Programming


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 使用动态规划的方式
        //1. 找出重复子问题
        //2. 状态空间的定义
        //3. DP方程

        //1 子问题：result[n]=Math.min(result[n],result[n+1])+triangle.get(level).get(n);
        //2. 状态空间的定义 result[] 用来存储当前层节点的最短路径
        //3. DP方程：result[n]=Math.min(result[n],result[n+1])+triangle.get(level).get(n);
        int row = triangle.size();
        int[] result = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int j = 0; j < triangle.get(level).size(); j++) {
                result[j] = Math.min(result[j], result[j + 1]) + triangle.get(level).get(j);
            }
        }
        return result[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
