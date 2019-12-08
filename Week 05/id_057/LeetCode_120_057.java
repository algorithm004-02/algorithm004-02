package app.homeworkWeekFifth;

import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (41.06%)
 * Likes:    1411
 * Dislikes: 164
 * Total Accepted:    208.5K
 * Total Submissions: 504.3K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal_dp_buttomUP(triangle);
    }

    /**
     * 自底向上
     * 第一层，
     * 递推公式f(n,j) = (n,j) + min(f(n + 1,j) ,f(n+1,j+1))
     * 时间复杂度O(m*n)
     * 空间复杂度O(m*n)
     * @param triangle
     * @return
     */
    private int minimumTotal_dp_buttomUP(List<List<Integer>> triangle) {
        //以题例
        //第一轮循环后，数组为[4,1,8,3,0]
        //第二轮循环后，数组为[7,6,10,3,0]
        //第三轮循环后，数组为[9,10,10,3,0]
        //第三轮循环后，数组为[11,10,10,3,0]
        //得出最小路径序列为11
        int rows = triangle.size();
        int [] cache = new int[rows + 1];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                cache[j] = Math.min(cache[j], cache[j + 1]) + triangle.get(i).get(j);
            }
        }
        return cache[0];
    }
}
// @lc code=end

