class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dps = new int[nums.length];
        int max = 0;
        Arrays.fill(dps, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    dps[i] = Math.max(dps[i], dps[i] + 1);

                }

            }
            max = Math.max(dps[i], max);


        }
        return max;
    }
}