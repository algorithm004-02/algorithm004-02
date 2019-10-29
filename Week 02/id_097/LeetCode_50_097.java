class Solution {
    public double myPow(double x, int n) {

        if (x == 0) {
            return 0;
        }

        return n < 0 ?  _myPow(1 / x, -n) : _myPow(x, n);

    }

    private double _myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        double half =  _myPow(x, n / 2);

        return n % 2 == 0 ? half * half : half * half * x;
    }
}