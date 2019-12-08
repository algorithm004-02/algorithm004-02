/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @version v1.0
 */
public class LeetCode_64 {

	/**
	 * 最短路径 dp 方程
	 * dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int[][] res = new int[grid.length][grid[0].length];
		res[0][0] = grid[0][0];
		// 计算第一列的每个坐标的最小值
		for (int i=1; i<grid.length; i++) {
			res[i][0] = grid[i][0]+res[i-1][0];
		}
		// 计算第一行的每个坐标的最小值
		for (int j=1; j<grid[0].length; j++) {
			res[0][j] = grid[0][j]+res[0][j-1];
		}
		for (int i=1; i<grid.length; i++) {
			for (int j=1; j<grid[0].length; j++) {
				res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
			}
		}

		return res[grid.length-1][grid[0].length-1];
	}

	/**
	 * 思路同解法1，因为每次只比较最近一行最小值的大小，所以减少为 n 个空间
	 * @param grid
	 * @return
	 */
	public int minPathSumV1(int[][] grid) {
		int[] res = new int[grid[0].length];
		int[] res[0] = grid[0][0];
		for (int i=1; i<grid[0].length; i++) {
			res[i] = res[i-1]+grid[0][i];
		}
		for (int i=1; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if (j=0) {
					res[0] = grid[i][j]+res[0];
				} else {
					res[j] = grid[i][j]+Math.min(res[j], res[j-1]);
				}
			}
		}
		return res[grid[0].length-1];
	}
}
