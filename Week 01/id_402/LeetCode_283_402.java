class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0){
                    if (i != index){
                        nums[index] = nums[i];//稍微进行一点优化，去除无效的替换操作
                        nums[i] = 0;
                    }
                    index ++;
                }
            }
        }
}