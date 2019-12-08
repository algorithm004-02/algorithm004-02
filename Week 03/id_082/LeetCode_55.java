/**
 * 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 输入: [2,3,1,1,4], 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 输入: [3,2,1,0,4], 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 */
public class LeetCode55 {

	/**
	 * 从数组最后往前遍历，查看每个元素是否可以跳跃已标记的可跳跃到位置
	 * @param nums 整数数组
	 * @return
	 */
	public boolean canJump(int[] nums) {
		if (nums == null) {
			return false;
		}

		int endReachable = nums.length-1;
		for (int i = nums.length-1; i>=0; i--) {
			if (nums[i]+i >= endReachable) {
				// 标记为最新的跳跃目标
				endReachable = i;
			}
		}

		return endReachable == 0;
	}

	/**
	 * 从数组头，开始遍历每个值，并查看值可跳跃到的每个位置，最后判断是否最后的位置可跳跃到
	 * @param nums 整数数组
	 * @return
	 */
	public boolean canJumpV2(int[] nums) {
		if (nums == null) {
			return false;
		}

		// 把所有位置初始化可不可跳跃到
		boolean[] visited = new boolean[nums.length];
		for (boolean v:visited) {
			v=false;
		}
		visited[0] = true;

		for (int i=0; i<nums.length-1; i++) {
			if (!visited[i]) break;
			int val = nums[i];
			// 标记当前键值所有可跳跃到的位置
			for (int j=0; j<=val; j++) {
				if (i+j <= nums.length-1) {
					visited[i+j] = true;
				}
			}
		}
		return visited[nums.length-1];
	}
}
