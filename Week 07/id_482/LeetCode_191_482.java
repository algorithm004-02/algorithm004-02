package com.study.week7.lesson14;

public class LeetCode_191_482 {

    // you need to treat n as an unsigned value

    /**
     * 最低位清零
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count=0;
        while (n != 0) {
            ++count;
            n &=n-1; //最低位清零
        }
        return count;
    }

    /**
     * method1 遍历
     * @param n
     * @return
     */
    public int hammingWeight_1(int n) {
        int count=0;
        int flag=1;
        for (int i=1;i<=32;i++) {
            if ((flag & n) != 0 ) {
                count++;
            }
            flag<<=1;
        }
        return count;
    }
}
