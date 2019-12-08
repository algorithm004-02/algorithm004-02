package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组
public class LeetCode_56_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_56_537().new Solution();
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {

            if (intervals.length <= 1)
                return intervals;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0],o2[0]);
                }
            });

            List<int[]> result = new ArrayList<>();
            result.add(intervals[0]);
            int[] temp = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0]<=temp[1])
                    temp[1] = Math.max(temp[1], intervals[i][1]);
                else {
                    result.add(intervals[i]);
                    temp = intervals[i];
                }
            }

            return result.toArray(new int[result.size()][]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}