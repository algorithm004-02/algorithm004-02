import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null) {
            return 0;
        }
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int x = 0, y = 0;
        int dir = 0;
        int result = 0;
        Set<String> blockSet = new HashSet<>();
        if (obstacles != null) {
            for (int[] block : obstacles) {
                blockSet.add(block[0] + "," + block[1]);
            }
        }
        for (int c : commands) {
            if (c == -1) {
                dir = (dir + 1) % 4;
            } else if (c == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < c; i++) {
                    int nextX = dirs[dir][0] + x;
                    int nextY = dirs[dir][1] + y;
                    if (!blockSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        result = Math.max(result, x * x + y * y);
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end
