class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0, r = nums.size() - 1;
        if(nums.size() == 1)    return nums[0];
        while(l <= r){
            int mid = l + (r - l) / 2;
            cout << mid << endl;
            if((mid == 0 && nums[mid] < nums[mid + 1]) || (mid == nums.size()-1 && nums[mid] < nums[mid - 1]) || (mid != 0 && mid != nums.size()-1 && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]))   return nums[mid];
            if(nums[r] <nums[l] && nums[mid] < nums[r]) r = mid - 1;
            else if(nums[r] > nums[l])  r = l;
            else if(nums[mid] > nums[r])    l = mid + 1;
        }
        return -1;
    }
};
