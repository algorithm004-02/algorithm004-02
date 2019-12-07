package solution;

import java.util.Arrays;

// 求众数
public class MajorityElement {
    public static void main(String[] args) {
        int[] data  = new int[] {2,3,1,3,1,2,2, 2};
        System.out.println("众数为： " + majorityElement(data));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
