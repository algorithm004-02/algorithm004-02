package datastruct.dp;

/**
 * Created by 10697 on 2019/11/8.
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        int result = fibonacciNumber.fib1(100,new int[101]);
        System.out.println(result);
    }

    public int fib (int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib (n - 2);
        }
    }

    public int fib1 (int n ,int[] meno) {
        if (n <= 1)
            return n;

        if (meno[n] == 0);
            meno[n] = fib1(n - 1,meno) + fib1(n - 2,meno);
        return meno[n];
    }



}
