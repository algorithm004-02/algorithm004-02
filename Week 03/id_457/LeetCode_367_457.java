//367. 有效的完全平方数
class Solution {
    //二分法
    // public boolean isPerfectSquare(int num) {
    //     int start = 1;
    //     int end = num;
    //     int mid = start + (end - start) / 2;
    //     while (start <= end) {
    //         if (Math.pow(mid, 2) > num) {
    //             end = mid-1;
    //         } else if (Math.pow(mid, 2) < num) {
    //             start = mid+1;
    //         } else {
    //             return true;
    //         }
    //         mid = start + (end - start) / 2;
    //     }
    //     return false;
    // }
    
    //公式法
    //利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}