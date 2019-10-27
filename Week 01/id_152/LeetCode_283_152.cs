public class Solution {
    public void MoveZeroes(int[] nums) {
        
        if (nums == null || nums.Length == 0) return;
        int slow = -1;
        for (int i = 0; i < nums.Length; i++){
            if (nums[i] != 0){
                slow++;
                if (i != slow){
                    nums[slow] = nums[i];
                    nums[i] = 0;
                }
            }
                
        }
    }
}