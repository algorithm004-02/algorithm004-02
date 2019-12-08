import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @version v1.0
 */
public class LeetCode_56 {
	public int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();
		if (intervals == null || intervals.length == 0) {
			return res.toArray(new int[0][]);
		}

		// 根据二维数组第一个数字大小按每一行整体排序
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int i=0;
		while (i < intervals.length) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			// i不能到最后一行，所以要小于（数组的长度-1）
			// 判断所在行的 right 和下一行的 left 大小，对 right 重新进行赋最大值，
			// 之后再不断进行 while 循环判断
			while (i < intervals.length-1 && right >= intervals[i+1][0]) {
				i++;
				right = Math.max(right, intervals[i][1]);
			}
			res.add(new int[]{left, right});
			i++;
		}
		return res.toArray(new int[0][]);
	}
}
