/*
* @Author: yangyazhen
* @Date:   2019-10-20 11:49:31
* @Last Modified by:   yangyazhen
* @Last Modified time: 2019-10-20 11:49:54
*/
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int size = nums.size(), j = 0;
        if (size == 0 ) return 0;
        for (int i = 1; i < size; i++) {
            if (nums[i] == nums[j]) {
                continue;
            } else {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
};

// 和移除0的题目有相似之处
// 双指针方法，将不重复的元素移动到数组前面
//执行用时 :20 ms, 在所有 cpp 提交中击败了99.48%的用户
// 内存消耗 :9.9 MB, 在所有 cpp 提交中击败了77.39%的用户

// warn ⚠️ 数组为空时需要特殊处理