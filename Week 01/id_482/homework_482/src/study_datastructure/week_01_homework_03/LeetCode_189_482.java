package study_datastructure.week_01_homework_03;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/19
 * @link
 */
public class LeetCode_189_482 {

    /**
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。
     * 然后把新的数组拷贝到原数组中。
     */
    public class Solution {
        public void rotate(int[] nums, int k) {
            int[] a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                a[(i + k) % nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = a[i];
            }
        }
    }
}
