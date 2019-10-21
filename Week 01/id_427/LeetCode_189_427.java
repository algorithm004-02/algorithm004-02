public void rotate(int[] nums, int k) {
        if(k >= nums.length) k %= nums.length;
        for(int i = 0;i < nums.length - k;i++){
            int tmp = nums[0];
            for(int j = 0;j<nums.length-1;j++){
                nums[j] = nums[j+1];
            }
            nums[nums.length-1] = tmp;
        }
    }