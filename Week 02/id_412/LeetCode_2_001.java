import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 按数组的值和索引存储在Map中
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int o = target - nums[i];
            // 查看有没有是目标值且不是自身的元素
            if (map.containsKey(o) && map.get(o) != i) {
                return new int[]{i, map.get(o)};
            }
        }
        throw new IllegalArgumentException();
    }
}
