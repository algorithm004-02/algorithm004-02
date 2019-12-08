/*
 * @lc app=leetcode.cn id=874 lang=cpp
 *
 * [874] 模拟行走机器人
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (30.09%)
 * Likes:    53
 * Dislikes: 0
 * Total Accepted:    3.9K
 * Total Submissions: 12.9K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * 
 * 
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 
 * 
 * 在网格上有一些格子被视为障碍物。
 * 
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 
 * 返回从原点到机器人的最大欧式距离的平方。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 
 * 
 * 示例 2：
 * 
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    enum _directION {
        EAST = 0,
        SOUTH = 1,
        WEST = 2,
        NORTH = 3,
    };

    struct POS {
        POS(int x, int y) : _x(x), _y(y) {}
        POS() { _x = 0; _y = 0; }
        bool operator < (const POS& right) const {
            if (_x == right._x) {
                return _y < right._y;
            } else {
                return _x < right._x;
            }
        }

        int _x;
        int _y;
    };

    class Robot {
    public:
        void do_cmd(int cmd, set<POS>& obstacles) {
            if (cmd > 0) {
                go_forward(cmd, obstacles);
            } else {
                change__direct(cmd);
            }
        }

        int calc_range() {
            return _pos._x * _pos._x + _pos._y * _pos._y;
        }

        int max_range() { return _max_range; }

    private:
        void change__direct(int change) {
            if (change == -2) {
                _direct = (_direct - 1 + 4) % 4;
            } else if (change == -1) {
                _direct = (_direct + 1) % 4;
            }
        }
        void go_forward(int step, set<POS>& obstacles) {
            if (step < 0) return;

            // 每一步尝试去找障碍，遇到障碍则停下来
            POS next_step = _pos;
            for (int i = 0; i < step; ++i) {
                switch (_direct) {
                case EAST:
                    next_step._x++;
                    break;
                case SOUTH:
                    next_step._y--;
                    break;
                case WEST:
                    next_step._x--;
                    break;
                case NORTH:
                    next_step._y++;
                    break;
                default:
                    break;
                }
                auto it = obstacles.find(next_step);
                if (it != obstacles.end()) {
                    // 遇到障碍，停下来
                    break;
                } else {
                    // 更新位置
                    _pos = next_step;

                    // 更新最大距离
                    auto range = calc_range();
                    if (range > _max_range) _max_range = range;
                }
            }
        }
        
        int _direct = NORTH;
        POS _pos;
        int _max_range = 0;
    };

    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {

        Robot c3po;

        set<POS> obstacles_set;
        for (auto& obs : obstacles) {
            if (obs.size() < 2) continue;
            POS pos(obs[0], obs[1]);

            obstacles_set.insert(pos);
        }

        for (int i = 0; i < commands.size(); ++i) {
            c3po.do_cmd(commands[i], obstacles_set);
        }

        return c3po.max_range();
    }
};
// @lc code=end

