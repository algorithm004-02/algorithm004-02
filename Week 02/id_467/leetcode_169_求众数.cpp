class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int target = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != target) {
                --cnt;
                if (cnt == 0) {
                    target = nums[i];
                    cnt = 1;
                }
            } else {
                ++cnt;
            }
        }
        return target;
    }
};