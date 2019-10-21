/*
* @Author: yangyazhen
* @Date:   2019-10-20 16:26:44
* @Last Modified by:   yangyazhen
* @Last Modified time: 2019-10-20 16:26:47
*/
class Solution {
public:
    int trap(vector<int>& height) {
        int count = 0, i = 0, top = 0, size = height.size();
        int * s = new int[size + 1];
        while (i < size) {
            while (top != 0 && height[s[top -1]] < height[i]) {
                top--;
                if (top == 0) break;
                int w = i - s[top - 1] - 1;
                int h = min(height[i], height[s[top - 1]]) - height[s[top]];
                count += h * w;
            }
            s[top++] = i++;
        }
        return count;
    }
};

// 存水的高度取决于左右边界中较高的一个
// 所有元素依次入栈，若该元素小于等于栈顶元素，继续入栈，若大于，将小于该元素的出栈并计算雨水
// 执行用时 :8 ms, 在所有 cpp 提交中击败了80.87%的用户
// 内存消耗 :9 MB, 在所有 cpp 提交中击败了92.57%的用户