class Solution {
	
	/**
	 * 双指针，index从0开始，fixpointer即固定指向数组的最后一个元素
	   index与fixpointer处的元素两两交换，index+1，继续交换，直到index == fixpointer
	   
	   时间复杂度O(k*N) 如果k大于N的话，则至少为O(N^2)  空间复杂度O(1)
	   测试后证实比较挫。
	 */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return;
        int index = 0, fixpointer = len - 1, temp;
        
        for(int m = 0; m < k; m++){
            while(index < len){
                //交换index和fixpointer元素
                temp = nums[index];
                nums[index] = nums[fixpointer];
                nums[fixpointer] = temp;
            
                index++;
            }
            //恢复
            index = 0;
        }
    }
}