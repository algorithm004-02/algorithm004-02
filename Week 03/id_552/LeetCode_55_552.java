package Week03;

import static java.lang.Math.max;

public class Solution55 {

    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;

            // k, i + nums[i]表示什么
            k = max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {

        int[] arr = {2, 0, 0, 3, 1, 1, 4};
        boolean ret = canJump(arr);
        System.out.print(ret);
    }

    public boolean canJump1(int[] nums) {

        //position表示需要到达的位置
        int position = nums.length - 1;
        for (int i = nums.length - 2 ; i >= 0 ; i--) {
            if(nums[i] + i >= position){
                position = i;
            }

        }
        return position == 0;

    }

}
