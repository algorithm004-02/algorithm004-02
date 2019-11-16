package Week03.Chapter10;

public class LeetCode_3_045 {
    public int jump(int[] nums) {
        // end 表示当前能跳的边界
        // 遍历数组的  到了边界  更新新的边界
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        final int[] nums = {2, 3, 1, 1, 4};
        final LeetCode_3_045 test = new LeetCode_3_045();
        System.out.println(test.jump(nums));
    }
}
