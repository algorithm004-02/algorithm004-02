package app.homeworkWeekTwo;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (45.29%)
 * Likes:    2797
 * Dislikes: 98
 * Total Accepted:    497K
 * Total Submissions: 1.1M
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        
        return climbStairs_recursion_cache(n);
    }

    /**
     * 递归 + 缓存 
     * 时间复杂度O(n) 
     * 空间复杂度O(n)
     * @param n
     * @return
     */
    private int climbStairs_recursion_cache(int n) {
        Map<Integer,Integer> cache = new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        return climbStairs_recursion(n, cache);
    }
    
    private int climbStairs_recursion(int n, Map<Integer,Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int sum = climbStairs_recursion(n - 1, cache) + climbStairs_recursion(n - 2, cache);
            cache.put(n, sum);
            return sum;
        }
    }

    
}
// @lc code=end

