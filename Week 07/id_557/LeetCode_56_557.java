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


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval :
                intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        intervalList.sort((o1, o2) -> o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1);

        List<Interval> result = new ArrayList<>();
        for (Interval interval :
                intervalList) {
            if (result.isEmpty() || result.get(result.size() - 1).end < interval.start) {
                result.add(interval);
            } else {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, interval.end);
            }
        }
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).start;
            ans[i][1] = result.get(i).end;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
