class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)return 0;
        int[]loc = new int[nums.length+1];
        loc[1] = nums[0];
        for(int i = 2;i < loc.length;i++)
            loc[i] = Integer.MAX_VALUE;
        
        int ans = 1;
        for(int i = 1;i < nums.length;i++)
        {
            int l = 1,r = ans;
            while(l <= r)
            {
                int mid = r+(l-r)/2;
                if(loc[mid] < nums[i])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            ans = Math.max(ans,l);
            loc[l] = Math.min(loc[l],nums[i]);
        }
        return ans;
    }
}