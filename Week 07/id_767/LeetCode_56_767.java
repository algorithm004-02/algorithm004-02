package algorithm.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * describe:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lixilong
 * @date 2019/11/25
 */
public class _56_Merge {

//
//  时间复杂度：O(n\log{}n)O(nlogn)
//
//  除去 sort 的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlgn)O(nlgn)
//  空间复杂度：O(1)O(1) (or O(n)O(n))
  /*如果我们按照区间的 start 大小排序，那么在这个排序的列表中可以合并的区间一定是连续的。

  如果当前区间的左端点在前一个区间的右端点之后，那么他们不会重合，我们可以直接将这个区间插入 merged 中；
  否则，他们重合，我们用当前区间的右端点更新前一个区间的右端点 end

  如果前者数值比后者大的话。*/



  public int[][] merge(int[][] intervals) {

    LinkedList<int[]> res = new LinkedList<>();
    if (intervals == null || intervals.length == 0)
        return res.toArray(new int[0][]);
    // 根据二维数组第一个数字大小按每一行整体排序【增序】
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    for (int i = 0; i < intervals.length; i++) {
      if (res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
        res.add(intervals[i]);
      } else {
        res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
      }
    }

    //为什么放0，0长度？可以看下源码就知道了
    return res.toArray(new int[0][0]);
  }

}
