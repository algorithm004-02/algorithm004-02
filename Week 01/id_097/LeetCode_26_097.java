
public class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0, j = 1;

        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]) {

                // 不重复，长度+1
                i++;

                // 慢指针后移
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
