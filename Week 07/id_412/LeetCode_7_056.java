package Week07.Chapter18.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_7_056 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // 1 2  8 15
        // 3 6 10 18
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> res = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new int[]{starts[j], ends[i]});
                // j记录当前未加入结果集的starts的位置
                // starts的位置大于上一个ends位置的值时  将starts的j位置到ends的i位置的区间加入到结果中
                j = i + 1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        final LeetCode_7_056 test = new LeetCode_7_056();
        int[][] arr = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        final int[][] res = test.merge(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print("[");
            for (int j = 0; j < res[i].length; j++) {
                System.out.printf("%d", res[i][j]);
                if (j < res[i].length - 1) {
                    System.out.printf(",");
                }
            }
            System.out.println("]");
        }
    }
}
