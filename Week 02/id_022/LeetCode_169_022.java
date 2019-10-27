//[169]求众数
//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MajorityElement {

    /**
     * 计数法
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int k = map.getOrDefault(n, 0) + 1;
            if (k > nums.length / 2) {
                return n;
            } else {
                map.put(n, k);
            }
        }
        return 0;
    }

    /**
     * 排序法
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        MajorityElement solution = new MajorityElement();
        if (solution.majorityElement1(nums) != 3) {
            throw new AssertionError("majorityElement1");
        }

        if (solution.majorityElement2(nums) != 3) {
            throw new AssertionError("majorityElement2");
        }
    }
}