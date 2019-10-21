#include <vector>

using namespace std;

// 删除排序数组中的重复项
// i记录移除重复项后数组的位置，j记录原数组位置
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int length = nums.size();
        if (length <= 1) {
            return length;
        }
        int i = 0;
        for (int j = 1; j < nums.size(); j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
};