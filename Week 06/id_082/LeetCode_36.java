import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 说明:
 * - 一个有效的数独（部分已被填充）不一定是可解的。
 * - 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * - 给定数独序列只包含数字 1-9 和字符 '.' 。
 * - 给定数独永远是 9x9 形式的。
 *
 * @version v1.0
 */
public class LeetCode_36 {
	public boolean isValidSudoku(char[][] board) {
		// 记录数字用于验证行是否有效
		HashMap<Integer, Integer>[] rows = new HashMap[9];
		// 记录数字用于验证列是否有效
		HashMap<Integer, Integer>[] columns = new HashMap[9];
		// 记录数字有用验证 3x3 宫格是否有效
		HashMap<Integer, Integer>[] boxes = new HashMap[9];
		for (int i=0; i<9; i++) {
			rows[i] = new HashMap<>();
			columns[i] = new HashMap<>();
			boxes[i] = new HashMap<>();
		}

		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				char num = board[i][j];
				if (num != '.') {
					int n = (int) num;
					// 计算得到当前宫格的键
					int box_index = (i/3)*3 + j/3;

					rows[i].put(n, rows[i].getOrDefault(n, 0)+1);
					columns[j].put(n, columns[j].getOrDefault(n, 0)+1);
					boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0)+1);

					if (rows[i].get(n)>1 || columns[j].get(n)>1 || boxes[box_index].get(n)>1) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
