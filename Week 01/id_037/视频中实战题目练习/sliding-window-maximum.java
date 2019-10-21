import java.util.ArrayDeque;

// https://leetcode-cn.com/problems/sliding-window-maximum/
// 1暴力法
// 时间复杂度 O(NK)
// 空间复杂度 O(N-k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] maxNums = new int[nums.length - k + 1];
        for (int i = 0; i < maxNums.length; i++) {
            int maxNum = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxNum = Math.max(maxNum, nums[j]);
            }
            maxNums[i] = maxNum;
        }
        return maxNums;
    }
}

// deque
class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        int[] maxNums = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.getFirst() < (i - k + 1)) deque.removeFirst();
            // 入队的元素，根据大小去碰撞对内的
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) deque.removeLast();
            deque.addLast(i);
            //将队头的元素输出
            if (i >= k -1) {
                maxNums[i-k+1] = nums[deque.getFirst()];
            }
            
        }
        return maxNums;
    }
}