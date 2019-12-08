package com.algorithm.qinchao.homework.week01;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/18 10:52
 * @description 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_66_202 {
    static boolean flag = false;

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] worst = new int[digits.length + 1];
        worst[0] = 1;
        return worst;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        System.out.println(ToStringBuilder.reflectionToString(LeetCode_66_202.plusOne(nums)));
    }
}
