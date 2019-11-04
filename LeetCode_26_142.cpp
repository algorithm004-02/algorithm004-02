class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) return 0;

	int cur = 0, next = 0, num = 1;
        while (cur < nums.size() && next < nums.size()) {
      	    if (nums[cur] >= nums[next]) {
        	next++;
     	    } else {
    	        if (cur + 1 >= nums.size()) break;
	        nums[cur+1] = nums[next];
	        cur++;
	        next = next+1;
     	        num++;
	    }
	}

	return num;
    }
};
