public int removeDuplicates(int[] nums) {
        if(nums.length==0||nums.length==1) return nums.length;
        int i = 0;
        int j = 0;
        int tmp;
        int length = 0;
        while (j<nums.length) {
            if (nums[j]==nums[i]) j++;
            else{
                tmp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j]=tmp;
                i++;
                j++;
            }
        }
        return i+1;
    }