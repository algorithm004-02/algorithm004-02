//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
class Solution {
    public void rotate(int[] nums, int k) {
        int last = 0;
        int i = 0;
        while(k>0){
            last = nums[nums.length-1];
            for(i = nums.length-1; i >0; --i){
                nums[i] = nums[i-1];
            }
            nums[0] = last;
            --k;
        }
    }
}