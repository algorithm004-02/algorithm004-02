package com.algorithm.qinchao.homework.week01;

import java.util.Stack;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/18 15:28
 * @description
 */
public class LeetCode_42_202 {
    public static int trapByPointer(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];
        //第一个不用比较啦，最大肯定是他自己，然后一直往左比较，找出每一次比较的最大值。
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            //这一次和上一次的比较，找出来
            max_left = Math.max(max_left, height[i - 1]);
            //如果然后这一次的值与最大值比较取小的，因为水的高度由短的的决定
            int min = Math.min(max_left, max_right[i]);
            //如果这个最小值都要大于当次的值，证明有阶梯的存在，肯定有坑
            if (min > height[i]) {
                //积水的话肯定是看阶梯的高度差啦
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


    public static int trapByStack(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum += distance * (min - h);
            }
            //将最高墙的index或者比之前矮的墙入栈
            stack.push(current);
            current++; //指针后移
        }
        return sum;

    }
    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(LeetCode_42_202.trapByPointer(height));
        System.out.println(LeetCode_42_202.trapByStack(height));
    }

}
