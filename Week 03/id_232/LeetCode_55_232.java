package src.main.java.com.fans.algorithm00402.week3.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 跳跃游戏
 */
public class LeetCode_55_232 {

    /**
     * 1. DFS  time limit
     */
//    public boolean canJump(int[] nums) {
//        return dfs(0, nums);
//    }
//
//    private boolean dfs(int currentStep, int[] nums) {
//        if (currentStep >= nums.length - 1) return true;
//
//        for (int i = nums[currentStep]; i > 0; i --) {
//            if (dfs(currentStep + i, nums)) return true;
//        }
//        return false;
//    }

    /**
     * 2. BFS time limit
     */
//    public boolean canJump(int[] nums) {
//        return bfs(0, nums);
//    }
//
//    private boolean bfs(int currentStep, int[] nums) {
//        if (nums.length == 1) return true;
//        Queue<Integer> queue = new LinkedList<>();
//        if (nums[currentStep] != 0) queue.add(currentStep);
//        while (!queue.isEmpty()) {
//            int step = queue.poll();
//            int num = nums[step];
//            while (num > 0) {
//                if (step + num >= nums.length - 1) return true;
//                queue.add(step + num);
//                num--;
//            }
//        }
//
//        return false;
//    }

    /**
     * 3. 反向贪心
     */
//    public boolean canJump(int[] nums) {
//        if (nums == null) return false;
//        int end = nums.length - 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] + i >= end) end = i;
//        }
//        return end == 0;
//    }

    /**
     * 4. 正向贪心
     */
    public boolean canJump(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i > end) return false;
            end = Math.max(end, nums[i] + i);
        }
        return true;
    }


    public static void main(String[] args) {
        LeetCode_55_232 code = new LeetCode_55_232();
         System.out.println(code.canJump(new int[]{2,3,1,1,4}));
    }
}
