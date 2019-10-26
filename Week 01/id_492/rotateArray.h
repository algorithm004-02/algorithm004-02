#include <vector>

using namespace std;

// 旋转数组
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int length = nums.size();
        k = k % length;
        // count记录数组的遍历次数
        int count = 0;
        // 没有遍历完所有数字但是回到出发数字，遍历下一个出发数字
        for (int start = 0; count < length; start++) {
            int prev = nums[start];
            int current = start;
            do {
                // 找到当前位置数字的目标位置
                int next = (current + k) % length;

                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (current != start);
        }
    }
};