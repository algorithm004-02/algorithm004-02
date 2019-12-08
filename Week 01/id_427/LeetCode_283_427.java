public void moveZeroes(int[] nums) {
        if(nums.length<2) return;
        int i=0;
        int j=1;
        int tmp=0;
        while (j<nums.length){
            if(nums[i]==0){
                if(nums[j]!=0){
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                    j++;
                }
                else j++;
            }
            else {
                i++;
                j = i+1;
            }
        }

    }