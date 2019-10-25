import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 */
public class TrappingRainWater {
	/**
	 * @Description: 方法1：以两个柱子为边界，积水只能发生在中间柱子比边界矮的情况下，通过
	 * 入栈来保存一个边界，循环数组。
	 * - 如果当前柱子高度小于栈顶高度，说明这里可能会有积水，当柱子的下标入栈
	 * - 如果当前柱子高度大于栈顶告诉，说明之前的积分在这里停下了，可以计算当前柱子和栈顶柱子之间的积水，
	 *   继续入栈
	 * @param height  n个不同高度的柱子数组
	 * @return:
	 * @Author: Yangjing
	 * @Date: 2019/10/20
	 */
	public int trapV1(int[] height) {
		int sum = 0, current=0;
		Stack<Integer> stack = new Stack<>();
		while (current < height.length) {
			// 如果栈不空，并且指向的高度大于栈顶高度就一直循环
			while (!stack.empty() && height[current] > height[stack.peek()]) {
				// 取出需要出栈的元素，并出栈
				int h = height[stack.pop()];
				// 栈空就出去
				if (stack.isEmpty()) {
					break;
				}
				// 两堵墙之间的距离
				int distance = current - stack.peek() - 1;
				int min = Math.min(height[stack.peek()], height[current]);
				sum = sum + distance*(min-h);
			}
			// 当前指向的墙入栈，指针后移
			stack.push(current++);
		}

		return sum;
	}
}
