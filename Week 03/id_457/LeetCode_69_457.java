class Solution {
    //二分法
//     public int mySqrt(int x) {
//         if (x == 0) {
//             return 0;
//         }
        
//         long left = 1;
//         long right = x/2;   //用long right = Integer.MAX_VALUE; 也可以。
        
//         while (left < right) {
//             long mid = (left + right + 1) >>> 1;
//             if (mid * mid > x) {
//                 right = mid - 1;
//             } else {
//                 left = mid;
//             }
//         }
//         return (int)left;
//     }
    
    //牛顿法
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a ) {
            x = (x + a/x) / 2;
        }
        return (int) x;
    }
}