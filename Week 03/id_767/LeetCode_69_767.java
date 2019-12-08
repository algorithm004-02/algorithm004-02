package algorithm.LeetCode;

/**
 * describe:
 * x 的平方根： https://leetcode-cn.com/problems/sqrtx/
 *
 * 精确度： 1^(-9)
 * @author lixilong
 * @date 2019/01/19
 */
public class _69_MySqrt {

  public static void main(String[] args) {
    _69_MySqrt mySqrt = new _69_MySqrt();
    System.out.println(mySqrt.mySqrt(5));
  }

  //直接调用库函数
//  public double mySqrt (int n ) {
//    return Math.sqrt(n);
//  }

  //方法2：可以用二分法拟合:以为Sqrt()是单调函数
  public double mySqrt (int n) {
    double left = 0.00000, mid = 0.00000, right = (double) n;
    while (left <= n) {
      mid = (right - left)/2 + left;
      double diff = Math.abs((mid - n / mid));
      if (diff < 1e-5) {
        return mid;
      } else if (diff > 0) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return -1;
  }

  //方法3 ： 牛顿迭代法实现平方根函数sqrt : 特殊函数 f =x^2 (函数表达式可描述),所以考虑逼近思路
  // https://blog.csdn.net/wdjhzw/article/details/40863859
  public int mySqrt (int n) {
    double x = 1.0;
    while(Math.abs(x*x-n) > 1e-5) {
      // (x, f(x))(x,f(x)) 的切线来逼近方程 x^2-n=0 的根
      //函数上任一点 (x,f(x))(x,f(x)) 处的切线斜率是 2x: x-f(x)/(2x)x−f(x)/(2x)
      //最终得 res = (x+n/x)/2
      x = (x+n/x)/2;
    }
    return (int)x;
  }


}
