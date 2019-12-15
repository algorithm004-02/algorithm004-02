//[874]模拟行走机器人
//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
//
//
// -2：向左转 90 度
// -1：向右转 90 度
// 1 <= x <= 9：向前移动 x 个单位长度
//
//
// 在网格上有一些格子被视为障碍物。
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1])
//
// 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
//
// 返回从原点到机器人的最大欧式距离的平方。
//
//
//
// 示例 1：
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
//
//
// 示例 2：
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
//
//
//
//
// 提示：
//
//
// 0 <= commands.length <= 10000
// 0 <= obstacles.length <= 10000
// -30000 <= obstacle[i][0] <= 30000
// -30000 <= obstacle[i][1] <= 30000
// 答案保证小于 2 ^ 31
//
// Related Topics 贪心算法


import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {

        Map<Integer, SortedSet<Integer>> obx = new HashMap<>(); // 行坐标为Key，列坐标排序
        Map<Integer, SortedSet<Integer>> oby = new HashMap<>(); // 列坐标为Key, 行坐标排序
        for (int[] ob : obstacles) {
            SortedSet<Integer> obxy = obx.get(ob[0]);
            if (obxy == null) {
                obxy = new TreeSet<>();
                obx.put(ob[0], obxy);
            }
            obxy.add(ob[1]);


            SortedSet<Integer> obyx = oby.get(ob[1]);
            if (obyx == null) {
                obyx = new TreeSet<>();
                oby.put(ob[1], obyx);
            }
            obyx.add(ob[0]);
        }

        int[][] D = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0, max = 0;
        for (int cmd : commands) {
            switch (cmd) {
                case -2:
                    d = (d + 3) % 4;
                    break;
                case -1:
                    d = (d + 1) % 4;
                    break;
                default:
                    int dx = D[d][0] * cmd, dy = D[d][1] * cmd;
                    if (dx != 0) {
                        x = move(oby.get(y), x, dx);
                    } else {
                        y = move(obx.get(x), y, dy);
                    }

                    max = Math.max(x * x + y * y, max);
            }
        }

        return max;
    }

    private int move(SortedSet<Integer> ob, int from, int dis) {
        int dest = from + dis;
        if (ob == null || ob.isEmpty()) {
            return dest;
        }

        SortedSet<Integer> range = dis > 0
                ? ob.tailSet(from + 1)
                : ob.headSet(from);
        if (range.isEmpty()) {
            return dest;
        } else if (dis > 0) {
            return Math.min(range.first() - 1, dest);
        } else {
            return Math.max(range.last() + 1, dest);
        }
    }

    public static void main(String[] args) {
        int[] commands;
        int[][] obstacles;
        int result;

        WalkingRobotSimulation solution = new WalkingRobotSimulation();

        commands = new int[]{4, -1, 3};
        obstacles = new int[0][0];
        result = solution.robotSim(commands, obstacles);
        System.out.println(result);

        commands = new int[]{4, -1, 4, -2, 4};
        obstacles = new int[][]{{2, 4}};
        result = solution.robotSim(commands, obstacles);
        System.out.println(result);

        commands = new int[]{-2, 8, 3, 7, -1};
        obstacles = new int[][]{{-4, -1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2, -1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}};
        result = solution.robotSim(commands, obstacles);
        System.out.println(result);
    }
}