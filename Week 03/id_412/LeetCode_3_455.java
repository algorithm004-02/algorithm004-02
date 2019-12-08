package Week03.Chapter10;

import java.util.Arrays;

public class LeetCode_3_455 {
    // https://leetcode-cn.com/problems/assign-cookies/description/
    // https://leetcode-cn.com/problems/assign-cookies/solution/tan-xin-jie-fa-by-cyc2018/
    public int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
        int[] grid = new int[]{2, 3};
        final int[] size = {2, 1};
        final LeetCode_3_455 test = new LeetCode_3_455();
        System.out.println(test.findContentChildren(grid, size));
    }
}
