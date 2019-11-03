package datastruct.MethodOfBisectio;

/**
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，
 * 则返回 True，否则返回 False。
 说明：不要使用任何内置的库函数，如  sqrt。
 示例 1：
 输入：16
 输出：True

 示例 2：
 输入：14
 输出：False
 *
 */
public class ValidPerfectSquare {

    /**
     * 拟牛顿法
     */
    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r*r > num) {
            r = (r + num/r) / 2;
        }
        return r*r == num;
    }

    /**
     *
     * 二分法
     */
    public boolean isPerfectSquare1(int num) {
        int low = 1,high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid  == num) {
                return true;
            }else if (mid * mid < num) {
                low = (int) mid +1;
            }else{
                high = (int) mid - 1;
            }
        }
        return false;
    }

    /**
     * 方法三：
     *  so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
     */
    public boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * 拟牛顿法变形
     */
    public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }



}
