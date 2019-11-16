package src.main.java.com.fans.algorithm00402.week3.homework;

/**
 * 柠檬水找零
 */
class LeetCode_860_232 {

    /**
     * 1. 直观解法 (贪心)
     *  - 从开始记录手上5元的个数
     *  - 如果个数小于0 ， 则不可以
     *  - 如果最后个数大于等于0， 则可以
     */
    public boolean lemonadeChange(int[] bills) {

        int tag = 5; // 都是5的倍数
        int tenCount = 0;
        int fiveCount = 0;

        for (int i = 0; i < bills.length; i ++) {
            if (bills[i] == 5) fiveCount ++;
            else if (bills[i] == 10) {
                tenCount ++;
                fiveCount --;
            } else if (bills[i] == 20) {
                if (tenCount > 0) {
                    tenCount --;
                    fiveCount --;
                } else {
                    fiveCount -= 3;
                }
            }

            if (fiveCount < 0)
                return false;
        }

        return true;
    }
}
