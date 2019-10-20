package week1;

import java.util.Stack;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/19 23:46
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

  /**
   * 使用栈来解决.
   * 1、使用current指向当前遍历的元素，如果current的高度小于栈顶的元素位置的高度，则入栈.
   * 2、如果current大于栈顶元素的位置的高度，则计算面积.
   * 3、面积计算有点按层计算的感觉，第一层 -> 第二层 ->
   * */
  public int trap(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int sum = 0;
    int current = 0;
    while (current < height.length) {
      while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
        /** 计算中间包含的面积 */
        int h = height[stack.peek()];
        stack.pop();
        if (stack.isEmpty()) {
          /** 没有左边界 */
          break;
        }
        int minHeight = Math.min(height[current], height[stack.peek()]);
        int distance = current - stack.peek() - 1;
        int area = distance * (minHeight - h);
        sum += area;
      }
      stack.push(current);
      current++;
    }
    return sum;
  }

  /**
   * 方法二, 循环遍历，找左右边界。
   * 1、找到左边的柱子，再向右去找它右边的柱子，找到了计算中间的装水量.
   * 2、要判断右边哪个是最合适的柱子.
   * */
  public int trap1(int[] height) {
    int left = -1;
    int right = -1;
    int sum = 0;
    for (int i = 0; i < height.length; i++) {
      // 找到右面柱子后，i需要从它开始计算.
      if (i < right) {
        continue;
      }
      if (left == -1 && height[i] > 0) {
        left = i;
      } else if (right == -1 && height[i] > 0) {
        right = i;
        // 找到右边柱子后，判断下是不是最右边的.
        if (height[right] >= height[left]) {
          sum += getArea(height, left, right);
          left = right;
          right = -1;
        } else {
          int j = right;
          while (j < height.length) {
            if (height[j] >= height[left]) {
              /** 如果找到高度大于左边的，那它就是最右边的 */
              right = j;
              break;
            } else if (height[j] > height[right]) {
              /** 找到了小于左边的，但是大于右边的，那天更可能是最右边的 */
              right = j;
            }
            j++;
          }
          sum += getArea(height, left, right);
          left = right;
          right = -1;
        }
      }
    }
    return sum;
  }

  public int getArea(int[] height, int i, int j) {
    System.out.println( i + "  " + j);
    int minHeight = Math.min(height[i], height[j]);
    int width = j - i - 1;
    if (width <= 0) {
      return 0;
    }
    int area = minHeight * width;
    int k = i + 1;
    while (k < j) {
      area -= height[k];
      k++;
    }
    System.out.println(area);
    return area;
  }

  public static void main(String[] args) {
    int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    System.out.println(trappingRainWater.trap(array));
  }
}
