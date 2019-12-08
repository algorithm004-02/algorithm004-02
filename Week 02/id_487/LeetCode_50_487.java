class LeetCode_50_487{

    /***
     *
     * 50题
     *
     * Pow(x, n)
     *
     * @param x
     * @param n
     * @return
     */
    private double fastPow(double x, long n) {
        //递归终止条件
        if (n == 0) {
            return 1.0;
        }
        double pow = fastPow(x, n / 2);
        if (n % 2 == 0) {
            pow = pow * pow;
        } else {
            pow = pow * pow * x;
        }
        return pow;
    }

    //对n为负数的指数，先进行处理
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
}