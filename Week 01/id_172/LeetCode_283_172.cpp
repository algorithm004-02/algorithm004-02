/*
* @Author: yangyazhen
* @Date:   2019-10-20 13:44:22
* @Last Modified by:   yangyazhen
* @Last Modified time: 2019-10-20 13:44:48
*/
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int j = 0;
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < size) {
            nums[j++] = 0;
        }
    }
};
// 执行用时 :16 ms, 在所有 cpp 提交中击败了93.90%的用户
// 内存消耗 :9.5 MB, 在所有 cpp 提交中击败了44.34%的用户

