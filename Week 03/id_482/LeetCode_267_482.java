package com.study.week3.lesson11;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/30
 * @link
 */
public class LeetCode_267_482 {

    /**
     * 暴力法
     * @param num
     * @return
     */
    public boolean isPerfectSquare_1(int num) {
        double i=0;
        while (i * i <num) i++;
        return i*i == num;
    }

    /**
     * 二分查找
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int le=0;
        int r=num;
        while (le <= r) {
            int mid=(le + r) >>> 1;
            if ((double)mid * mid > num) r=mid-1;
            else if ((double)mid * mid < num) le=mid+1;
            else return true;
        }
        return false;
    }
}
