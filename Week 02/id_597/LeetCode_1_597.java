import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * Created by yangwenwei on 2019/10/25.
 */
public class LeetCode_1_597 {
    class Solution {
        //暴力
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                int sub = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == sub) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }

        //两遍哈希表
        public int[] twoSum1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int sub = target - nums[i];
                // map.get(sub) != i, 用于确定不能重复使用元素
                if (map.containsKey(sub) && map.get(sub) != i) {
                    return new int[]{i, map.get(sub)};
                }
            }
            return new int[0];
        }

        //一遍哈希表
        //在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int sub = target - nums[i];
                if (map.containsKey(sub)) {
                    return new int[]{map.get(sub), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }

    }
}
