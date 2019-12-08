package Week03.Chapter10;

public class LeetCode_3_055 {
    private boolean canJump(int[] nums) {
        if(nums==null){
            return false;
        }
        int endReachable = nums.length -1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(nums[i]+i>=endReachable){
                endReachable = i;
            }
        }
        return endReachable ==0;
    }

    public static void main(String[] args) {
        final int[] nums = {2, 3, 1, 1, 4};
        final LeetCode_3_055 test = new LeetCode_3_055();
        System.out.println(test.canJump(nums));
    }
}
