package src.main.java.com.fans.algorithm00402.week3.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 跳跃游戏2
 */
public class LeetCode_45_232 {
    /**
     * 1. BFS time limit
     */
//    public int jump(int[] nums) {
//        return bfs(nums);
//    }
//
//    private int bfs(int[] nums) {
//        if (nums.length == 1) return 0;
//        Queue<Integer> queue = new LinkedList<>();
//        if (nums[0] != 0) queue.add(0);
//        int level = 0;
//        while (!queue.isEmpty()) {
//            level ++;
//            int size = queue.size();
//            while (size -- > 0) {
//                int step = queue.poll();
//                int num = nums[step];
//                while (num > 0) {
//                    if (step + num >= nums.length - 1) return level;
//                    queue.add(step + num);
//                    num--;
//                }
//            }
//        }
//
//        return level;
//    }

    /**
     * 2. 贪心
     */
//    public int jump(int[] nums) {
//        int end = 0;
//        int max = 0;
//        int count = 0;
//        for (int i = 0; i < nums.length - 1; i ++) {
//            max = Math.max(max, nums[i] + i);
//            if (i == end) {
//                end = max;
//                count ++;
//            }
//        }
//        return count;
//    }

    /**
     * 3. 循环
     */
    public int jump(int[] nums) {
        int end = nums.length - 1;
        int count = 0;
        while (end != 0) {
            for (int i = 0; i < end; i ++) {
                if (nums[i] + i >= end) {
                    count ++;
                    end = i;
                    break;
                }
            }
        }
        return count;
    }
}
