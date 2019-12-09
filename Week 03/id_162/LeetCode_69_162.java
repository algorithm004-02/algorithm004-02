class Solution {
    public int mySqrt(int x) {
        //    x为非负整数，即0，1，2，3...
        long l = 0;
        long r = x;
        long mid = 0;

        while (l < r) {
            // 使用l+r，可能会溢出
            // +1，使用右边界，避免死循环
            mid = l + (r - l + 1) / 2;

            long square = mid * mid;
            if (square > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int) l;
    }
}