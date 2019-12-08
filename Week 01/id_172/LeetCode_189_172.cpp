/*
* @Author: yangyazhen
* @Date:   2019-10-20 13:42:38
* @Last Modified by:   yangyazhen
* @Last Modified time: 2019-10-20 13:42:41
*/
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int size = nums.size(), tmp = 0;
        k = k % size;
        for(int i = 0, j = size - 1; i < j; i++, j--) {
            tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        for(int i = 0, j = k - 1; i < j; i++, j--) {
            tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        for(int i = k, j = size - 1; i < j; i++, j--) {
            tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }
};

// 1. 利用mod运算，替换数组元素
//.   注意当 size % k == 0时存在循环替换的问题
// 执行用时 :20 ms, 在所有 cpp 提交中击败了95.58%的用户
// 内存消耗 :9.6 MB, 在所有 cpp 提交中击败了22.48%的用户
// 2.反转数组
// 执行用时 :20 ms, 在所有 cpp 提交中击败了95.58%的用户
// 内存消耗 :9.6 MB, 在所有 cpp 提交中击败了29.03%的用户