package week02;

/*
169. 求众数

给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

    输入: [3,2,3]
    输出: 3

示例 2:

    输入: [2,2,1,1,1,2,2]
    输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/**
 * @author Will WM. Zhang
 * @since 2019-10-23 14:52
 */
public class LeetCode_169_177 {

    public static void main(String[] args) {
        LeetCode_169_177 test = new LeetCode_169_177();

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int result = test.majorityElement(nums);

        System.out.println("result: " + result);
    }

    private int majorityElement(int[] nums) {
        int len = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count = count + 1;
                }
            }
            if (count > len) {
                return nums[i];
            }
        }

        return -1;
    }
}
