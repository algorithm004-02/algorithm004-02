import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 求众数
 * Created by yangwenwei on 2019/10/27.
 */
public class LeetCode_169_597 {
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement4(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    static class Solution {
        //暴力,带有缓存. 已被数过的元素不再数
        public int majorityElement(int[] nums) {
            Set<Integer> counted = new HashSet<>();
            int majorityCount = nums.length / 2;
            for (int i = 0; i < nums.length; i++) {
                //已被数过的元素不再数
                if (counted.contains(nums[i])) continue;
                int count = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) count++;
                }
                counted.add(nums[i]);
                if (count > majorityCount) return nums[i];
            }
            return -1;
        }

        //哈希表
        public int majorityElement1(int[] nums) {
            if (nums.length == 1) return nums[0];
            Map<Integer, Integer> map = new HashMap<>();
            int majorityCount = nums.length / 2;
            for (int num : nums) {
                if (map.containsKey(num)) {
                    int count = map.get(num) + 1;
                    //在统计过程中判断是否为众数
                    if (count > majorityCount) return num;
                    map.put(num, count);
                } else map.put(num, 1);
            }
            return -1;
        }

        //排序
        //如果所有数字被单调递增或者单调递减的顺序排了序，那么众数的下标为nums.length / 2
        public int majorityElement2(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }

        //分治递归
        public int majorityElement3(int[] nums) {
            return recursion(nums, 0, nums.length - 1);
        }

        private int countInRange(int[] nums, int num, int low, int high) {
            int count = 0;
            for (int i = low; i <= high; i++) if (nums[i] == num) count++;
            return count;
        }

        private int recursion(int[] nums, int low, int high) {
            //数组只有一个数,众数即为本身
            if (low == high) return nums[low];
            // recurse on left and right halves of this slice.
            int mid = (high - low) / 2 + low;
            int left = recursion(nums, low, mid);
            int right = recursion(nums, mid + 1, high);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }
            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, low, high);
            int rightCount = countInRange(nums, right, low, high);

            return leftCount > rightCount ? left : right;
        }


        //投票法
        public int majorityElement4(int[] nums) {
            int count = 0;
            Integer candidate = null;
            for (int num : nums) {
                if (count == 0) candidate = num;
                count += (num == candidate) ? 1 : -1;
            }
            return candidate == null ? -1 : candidate;

        }
    }
}
