/**
 * Created by kaiyun on 2019/10/18.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[zIndex];
                nums[zIndex] = tmp;
                zIndex ++;
            }
        }
    }
}
