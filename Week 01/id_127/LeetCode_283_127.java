public class Solution {
	public void moveZeroes(int[] nums) {
        if(null == nums || nums.length == 0) {
        	return;
        }
        int notZeroPos = -1;
        int firstZeroPos = -1;
        boolean isFindFirstZero = false;
        for(int i = 0; i < nums.length; i++) {
        	
        	if(nums[i] == 0 && !isFindFirstZero) {
        		firstZeroPos = i;
        		isFindFirstZero = true;
        	} else if(nums[i] != 0) {
        		notZeroPos = i;
        	}
        	if(isFindFirstZero && firstZeroPos < notZeroPos) {
        		int tmp = nums[firstZeroPos];
        		nums[firstZeroPos] = nums[notZeroPos];
        		nums[notZeroPos] = tmp;
        		notZeroPos = firstZeroPos;
    			firstZeroPos++;
        	}
        }
    }
}