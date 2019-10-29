#include <vector>

using namespace std;

// 接雨水 双指针法
class Solution {
public:
    int trap(vector<int>& height) {
        int begin = 0;
        int end = height.size() - 1;
        int capacity = 0;
        int leftmax = 0, rightmax = 0;
        while (begin < end) {
            if (height[begin] < height[end]) {
                if (height[begin] >= leftmax) {
                    leftmax = height[begin];
                }
                else {
                    capacity += leftmax - height[begin];
                }
                ++begin;
            }
            else {
                if (height[end] >= rightmax) {
                    rightmax = height[end];
                }
                else {
                    capacity += rightmax - height[end];
                }
                --end;
            }
        }
        return capacity;
    }
};