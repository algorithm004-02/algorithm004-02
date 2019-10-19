import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
// class Solution {
//     public List<List<Integer>> threeSum(int[] num) {
//         Arrays.sort(num);
//         List<List<Integer>> res = new LinkedList<>();
//         for (int i = 0; i < num.length - 2; i++) {
//             if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
//                 int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
//                 while (lo < hi) {
//                     if (num[lo] + num[hi] == sum) {
//                         res.add(Arrays.asList(num[i], num[lo], num[hi]));
//                         while (lo < hi && num[lo] == num[lo + 1])
//                             lo++;
//                         while (lo < hi && num[hi] == num[hi - 1])
//                             hi--;
//                         lo++;
//                         hi--;
//                     } else if (num[lo] + num[hi] < sum)
//                         lo++;
//                     else
//                         hi--;
//                 }
//             }
//         }
//         return res;
//     }
// }
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            if (i == 0 || (i > 0 && (nums[i] != nums[i - 1]))) {
                int low = i + 1;
                int high = size - 1;
                while (low < high) {
                    int sum = nums[low] + nums[high] + nums[i];
                    if (sum == 0) {
                        List<Integer> res = Arrays.asList(nums[i], nums[low], nums[high]);
                        results.add(res);
                        while (low < high && nums[low + 1] == nums[low])
                            low++;
                        while (low < high && nums[high - 1] == nums[high])
                            high--;
                        low++;
                        high--;
                    } else if (sum < 0) {
                        while (low < high && nums[low + 1] == nums[low])
                            low++;
                        low++;
                    } else {
                        while (low < high && nums[high - 1] == nums[high])
                            high--;
                        high--;
                    }
                }
            }

        }
        return results;

    }
}
// @lc code=end
