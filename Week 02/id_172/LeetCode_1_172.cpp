class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int size = (int)nums.size(), other = 0;
        map<int, int> mapper;
        for (int i = 0; i < size; i++) {
            other = target - nums[i];
            map<int, int>::iterator iter = mapper.find(other);
            if (iter != mapper.end() && iter->second != i) {
                return { mapper.find(other)->second, i};
            }
            mapper.insert({nums[i], i});
        }
        return {0, 0};
    }
};

// 1。暴力破解
// 列举所有可能的组合
// class Solution {
// public:
//     vector<int> twoSum(vector<int>& nums, int target) {
//         int size = nums.size();
//         for (int i = 0; i< size - 1; i++){
//             for (int j = i + 1; j < size; j++) {
//                 if ( nums[i] + nums[j] == target) {
//                     return  {i, j};
//                 }
//             }
//         }
//         return {0, 0};
//     }
// };
//  2 两边哈希表
// class Solution {
// public:
//     vector<int> twoSum(vector<int>& nums, int target) {
//         int size = (int)nums.size(), other = 0;
//         map<int, int> mapper;
//         for (int i = 0; i < size; i++) {
//             mapper.insert({nums[i], i});
//         }
//         for (int i = 0; i < size; i++) {
//             other = target - nums[i];
//             map<int, int>::iterator iter = mapper.find(other);
//             if (iter != mapper.end() && iter->second != i) {
//                 return {i, mapper.find(other)->second};
//             }
//         }
//         return {0, 0};
//     }
// };
