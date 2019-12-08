/**
 * 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * 遍历二维数组，碰见为 '1' 的陆地连接陆地全部转为 '0' 水，碰见的次数即为岛屿的数量
 */
public class LeetCode200 {

	/**
	 * x 轴
	 */
	int dx[] = new int[]{-1, 1, 0, 0};
	/**
	 * y 轴
	 */
	int dy[] = new int[]{0, 0, -1, 1};
	char[][] g;
	
	/**
	 * @Description: 计算二维数组中的岛屿数量
	 * @param  岛屿数组
	 */
	public int numIslands(char[][] grid) {
		int isLands = 0;
		g = grid;
		for (int i=0; i<g.length; i++) {
			for (int j=0; j<g[i].length; j++) {
				if (g[i][j] == '0') continue;
				isLands += sink(i, j);
			}
		}
		return isLands;
	}

	/**
	 * 将下标 x,y 点的陆地转换为水
	 * @param i
	 * @param j
	 * @return
	 */
	private int sink(int i, int j) {
		if (g[i][j] == '0') return 0;

		// 原本 i,j == '1'
		g[i][j] = '0';

		// 通过 x,y 数组计算得到与 i,j 坐标的连接的 4 个坐标的位置
		for (int k=0; k<dx.length; ++k) {
			int x = i+dx[k], y = j+dy[k];
			// 当坐标在数组中，并为岛屿的时候，将陆地转化为水
			if (x>=0 && x<g.length && y>=0 && y<g[i].length) {
				if (g[x][y] == '0') continue;
				sink(x, y);
			}
		}
		return 1;
	}
}
