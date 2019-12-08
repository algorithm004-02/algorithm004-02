import java.util.Arrays;

public class LeetCode_45_047 {

    public int canJump(int[] nums) {

        int step = 0;
        int currFarthest = 0;
        int currEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                step ++;
                currEnd = currFarthest;
            }
        }
        return step;
    }
}
