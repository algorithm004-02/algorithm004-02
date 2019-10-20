class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        int tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[1] = tmp;
        }
    }
}