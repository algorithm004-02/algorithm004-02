package com.study.week3.lesson10;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/30
 * @link https://leetcode-cn.com/problems/lemonade-change/
 */
public class LeetCode_860_482 {

    /**
     * 贪心算法
     * 尽可能多的把5元留在手上
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for (int b : bills) {
            if (b==5) {
                five++;
            }else if (b == 10) {
                if (five-- == 0) {
                    return false;
                }
                ten++;
            }else {
                if (ten > 0 && five>0) {
                    ten--;five--;
                }else if (five > 2) {
                    five-=3;
                }else {
                    return false;
                }
            }

        }
        return true;
    }
}
