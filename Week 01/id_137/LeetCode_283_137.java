public class LeetCode_283_137 {
    public void moveZeroes(int[] nums) {
        assert nums != null;
        int insertIndex = 0;
        for (int num : nums) {
            if (num != 0) nums[insertIndex++] = num;
        }
        while (insertIndex < nums.length) {
            nums[insertIndex++] = 0;
        }
    }
}
